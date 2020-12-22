package com.example.projekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Luokka sisältää Salibandy liikuntavuoron lisätiedot ja napin siihen ilmoittautumiseen
 * @author Kasperi Kiviluoma
 * @author Toni Franciskovic
 */

public class LiikuntavuoronTiedotActivity extends AppCompatActivity {
    private int ilmottauduNapinTila;

    /**
     * Kuuntelee ilmoittaudu napin tilaa ja muuttaa sen klikkauksesta ilmoittaudu/ilmoittauduttu
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liikuntavuoron_tiedot);

        SharedPreferences napinTila = getPreferences(Context.MODE_PRIVATE);
        ilmottauduNapinTila = napinTila.getInt("napinArvo", 1);

        paivitaUI();    //Hae sovelluksen käynnistyessä ilmoittaudu napille tila

        Button btnIlmoittaudu = findViewById(R.id.btnIlmoittaudu);
        btnIlmoittaudu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                /* Jos tunnille on jo ilmoittauduttu aikaisemmin, mutta halutaan perua ilmoittautuminen, tarkistetaan että "Tulevat"-listan koko on suurempi kuin 0,
                ja poistetaan listalta sinne lisätty ilmoittautuminen. */

                if (ilmottauduNapinTila == 0) {
                    if (GlobalLiikuntavuorotListat.haeInstanssi().haeTulevat().size() == 0){
                        GlobalLiikuntavuorotListat.haeInstanssi().haeTulevat().add(new LiikuntaVuoro("Salibandy", "Maanantai 12.10. klo 16.00 - 17.00,", "Fressimpi Jätkäsaari"));

                    } else if (GlobalLiikuntavuorotListat.haeInstanssi().haeTulevat().size() > 0) {
                        GlobalLiikuntavuorotListat.haeInstanssi().haeTulevat().remove(0);

                    }
                    Toast.makeText(LiikuntavuoronTiedotActivity.
                            this, "Olet perunut tunnille ilmoittautumisen", Toast.LENGTH_LONG).show();
                    ilmottauduNapinTila = 1;
                } else if (ilmottauduNapinTila == 1) {

                    /* Jos tunnille ei ole vielä ilmoittauduttu, ilmoittaudutaan napin painaluksella ja samalla lisätään tunti "Tulevat"-listalle */

                    GlobalLiikuntavuorotListat.haeInstanssi().haeTulevat().add(new LiikuntaVuoro("Salibandy", "Maanantai 12.10. klo 16.00 - 17.00", "Fressimpi Jätkäsaari"));
                    Toast.makeText(LiikuntavuoronTiedotActivity.
                            this, "Olet ilmoittautunut tunnille", Toast.LENGTH_LONG).show();
                    ilmottauduNapinTila = 0;
                }
                paivitaUI();    //napin tila klikkauksen jälkeen
            }
        });
    }

    /**
     * päivitä UI onStartissa
     */

    protected void onStart() {
        super.onStart();
        paivitaUI();
    }

    /**
     * päivitä UI onResumessa
     */

    protected void onResume() {
        super.onResume();
        paivitaUI();
    }

    /**
     * laita ilmoittaudu napin tila SharedPreferenceihin onPausella
     */

    protected void onPause() {
        SharedPreferences napinTila = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor napinTilaEditori = napinTila.edit();
        napinTilaEditori.putInt("napinArvo", ilmottauduNapinTila);
        napinTilaEditori.apply();

        super.onPause();
    }

    /**
     * Jos appi tuhotaan androidin toimesta niin napin tila tallentuu silti
     */

    protected void onStop() {
        SharedPreferences napinTila = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor napinTilaEditori = napinTila.edit();
        napinTilaEditori.putInt("napinArvo", ilmottauduNapinTila);
        napinTilaEditori.apply();

        super.onStop();
    }

    /**
     * päivitä ilmoittaudu napin teksti ja väri oikeiksi
     */

    public void paivitaUI() {
        Button btnIlmoittaudu = findViewById(R.id.btnIlmoittaudu);
        if (ilmottauduNapinTila == 0) {
            btnIlmoittaudu.setText("Ilmoittauduttu");
            btnIlmoittaudu.setBackgroundResource(R.color.button_background_color_harmaa);
        } else if (ilmottauduNapinTila == 1) {
            btnIlmoittaudu.setText("Ilmoittaudu");
            btnIlmoittaudu.setBackgroundResource(R.color.button_background_color);
        }
    }
}