package com.example.projekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Luokka näyttää MainActivityssa valitun lajin mukaisen listauksen saatavilla olevista liikuntavuoroista
 * @author Kasperi Kiviluoma
 */

public class LiikuntavuorotListattunaActivity extends AppCompatActivity {
    public static final String EXTRA = "liikuntaVuoroIDJuoksupoika";    //Listassa klikatun liikuntavuoron id
    // jotta osataan klikkauksen jälkeen näyttää oikea lisäinfo ja varausnappi


    /**
     * Asettaa listan näkyviin MainActivityssa klikatun lajin mukaan. Kuuntelee mitä kohtaa listasta on klikattu
     * ja avaa lisätieto näkymän sen mukaisesti. (Vain Salibandyn lisätieto näkymä toimii tällä hetkellä)
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liikuntavuorot_listattuna);

        Bundle b = getIntent().getExtras();     //hae mainista klikatun napin id
        assert b != null;
        int nappiIndeksi = b.getInt(MainActivity.EXTRA2, 0);

        final ListView lv = findViewById(R.id.liikuntaVuorotListView);
        ArrayAdapter<LiikuntaVuoro> listaAdapteri = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                GlobalLiikuntavuorotListat.haeInstanssi().haeOikeaLista(nappiIndeksi));
        lv.setAdapter(listaAdapteri);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {   //Kuuntele mitä kohtaa on painettu ja avaa lisäinfo activity sen mukaan
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("Klikattu", "position " + i + " clicked!");

                if (i == 1) {
                    Intent nextActivity = new Intent(LiikuntavuorotListattunaActivity.this, LiikuntavuoronTiedotActivity.class);
                    nextActivity.putExtra(EXTRA, i);
                    startActivity(nextActivity);
                }
            }
        });
    }
}