package com.example.projekti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Luokka sisältää listattuna tulevat tapahtumat, joihin käyttäjä on ilmoittautunut.
 * @author Toni Franciskovic
 */

public class TulevatActivity extends AppCompatActivity {

    private ListView lv;
    private ArrayAdapter<LiikuntaVuoro> listAdapter;
    private List<LiikuntaVuoro> liikuntaVuorot = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tulevat);

        // Lista, johon tapahtumat ilmestyvät kun niiden "Ilmoittaudu"-nappia painetaan.

        ListView lv = findViewById(R.id.tulevatLista);
        this.listAdapter =  new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                GlobalLiikuntavuorotListat.haeInstanssi().haeTulevat());

        lv.setAdapter(this.listAdapter);
    }
}