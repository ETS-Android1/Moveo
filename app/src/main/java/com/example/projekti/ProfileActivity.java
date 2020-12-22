package com.example.projekti;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Luokka sisältää profiilin tietojen muokkaamisen ja esittelyyn käytettäviä apuvälineitä
 * @author Aivan Vo
 * @author Kasperi Kiviluoma
 * @version 6.10/2020
 */

public class ProfileActivity extends AppCompatActivity implements ProfileDialog.ProfileDialogListener {
    private TextView txtViewNimi;
    private TextView txtViewIka;
    private TextView txtViewSukupuoli;
    private TextView txtViewSahkoposti;
    private TextView txtViewMaksutiedot;
    private Button btnMuokkaa;
    private String nimiNyt, ikaNyt, sukupuoliNyt, sahkopostiNyt, maksutiedotNyt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        /**
         * Hakee SharedPreferensseistä sinne tallennetut käyttäjän syöttämät tiedot nimi, yms.
         */
        SharedPreferences tallennetutTiedot = getPreferences(Context.MODE_PRIVATE);
        nimiNyt = tallennetutTiedot.getString("tallennettuNimi", "0");
        ikaNyt = tallennetutTiedot.getString("tallennettuIka", "0");
        sukupuoliNyt = tallennetutTiedot.getString("tallennettuSukupuoli", "0");
        sahkopostiNyt = tallennetutTiedot.getString("tallennettuSahkoposti", "0");
        maksutiedotNyt = tallennetutTiedot.getString("tallennettuMaksutiedot", "0");


        TextView helloTextView = (TextView) findViewById(R.id.txtViewNimi);
        helloTextView.setText(nimiNyt);
        TextView helloTextView2 = (TextView) findViewById(R.id.txtViewIka);
        helloTextView2.setText(ikaNyt);
        TextView helloTextView3 = (TextView) findViewById(R.id.txtViewSukupuoli);
        helloTextView3.setText(sukupuoliNyt);
        TextView helloTextView4 = (TextView) findViewById(R.id.txtViewSahkoposti);
        helloTextView4.setText(sahkopostiNyt);
        TextView helloTextView5 = (TextView) findViewById(R.id.txtViewMaksutiedot);
        helloTextView5.setText(maksutiedotNyt);


        txtViewNimi = findViewById(R.id.txtViewNimi);
        txtViewIka = findViewById(R.id.txtViewIka);
        txtViewSukupuoli = findViewById(R.id.txtViewSukupuoli);
        txtViewSahkoposti = findViewById(R.id.txtViewSahkoposti);
        txtViewMaksutiedot = findViewById(R.id.txtViewMaksutiedot);
        btnMuokkaa = findViewById(R.id.btnMuokkaa);

        /**
         * "Muokkaa tietoja" nappia klikkaamalla avautuu uusi aktiviteetti (Class: ProfileDialog.java)
         */
        btnMuokkaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }


    public void openDialog() {
        ProfileDialog profileDialog = new ProfileDialog();
        profileDialog.show(getSupportFragmentManager(), "profileDialog");
    }


    /**
     * Asettaa syötetyt muutokset profiilinäkymään, sekä tallentaa käyttäjän syöttämät tiedot nimi yms.
     * @param nimi, käyttäjän nimi
     * @param ika, käyttäjän ikä
     * @param sukupuoli, käyttäjän sukupuoli
     * @param sahkoposti, käyttäjän sähköpostiosoite
     * @param maksutiedot, käyttäjän maksukortin tiedot
     */
    @Override
    public void applyTexts(String nimi, String ika, String sukupuoli, String sahkoposti, String maksutiedot) {
        txtViewNimi.setText(nimi);
        txtViewIka.setText(ika);
        txtViewSukupuoli.setText(sukupuoli);
        txtViewSahkoposti.setText(sahkoposti);
        txtViewMaksutiedot.setText(maksutiedot);

        SharedPreferences tallennetutTiedot = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor tiedotEditori = tallennetutTiedot.edit();
        tiedotEditori.putString("tallennettuNimi", nimi);
        tiedotEditori.putString("tallennettuIka", ika);
        tiedotEditori.putString("tallennettuSukupuoli", sukupuoli);
        tiedotEditori.putString("tallennettuSahkoposti", sahkoposti);
        tiedotEditori.putString("tallennettuMaksutiedot", maksutiedot);
        tiedotEditori.apply();
    }
}