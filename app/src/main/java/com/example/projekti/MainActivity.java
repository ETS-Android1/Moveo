package com.example.projekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

/**
 * Luokka sisältää jokaisen ImageButtonin määrittelyn, nappien painallusta seuraavat tapahtumat, menu-valikon ja hakukentän.
 * @author Toni Franciskovic
 * @author Kasperi Kiviluoma
 */

public class MainActivity extends AppCompatActivity {

    ImageButton profileButton, mailaButton, juoksuButton, painoButton, nyrkkeilyButton, uintiButton, palloiluButton, joogaButton, pyorailyButton, tanssiButton;
    private Intent intent;
    public static final String EXTRA2 = "buttonIDjuoksupoika";   // lähetä napin id jotta osataan hakea oikea lista näytettäväksi

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Menu-valikon toiminta

        final String[] vaihtoehdot = {" ", "Tulevat tunnit", "Historia"};
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, vaihtoehdot);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            /**
             * Menu-valikon toiminta
             * @param parent AdapterView, AdapterView jossa valinta tapahtuu
             * @param view View, view joka valittiin AdapterViewin sisällä
             * @param position int, viewin positio adapterin sisällä
             * @param id long, valinnan rivin id.
             */

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, TulevatActivity.class);
                        startActivity(intent);
                        spinner.setSelection(0); // Valinnan suorittamisen jälkeen asetetaan spinnerin arvo takaisin tyhjään arvoon.
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, HistoriaActivity.class);
                        startActivity(intent);
                        spinner.setSelection(0); // Valinnan suorittamisen jälkeen asetetaan spinnerin arvo takaisin tyhjään arvoon.
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Profiilinapin toiminta

        profileButton = (ImageButton) findViewById(R.id.profileButton);
        profileButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);

            }

        });

        mailaButton = (ImageButton) findViewById(R.id.mailaButton);   //napin painallus avaa listanäkymän valitun lajin vuoroista ja laittaa juoksupojan matkaan
        mailaButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("Nappia painettu", "position " + R.id.mailaButton + " clicked!");
                Intent nextActivity = new Intent(MainActivity.this, LiikuntavuorotListattunaActivity.class);
                nextActivity.putExtra(EXTRA2, R.id.mailaButton);
                startActivity(nextActivity);
            }
        });

        juoksuButton = (ImageButton) findViewById(R.id.juoksuButton);   //napin painallus avaa listanäkymän valitun lajin vuoroista ja laittaa juoksupojan matkaan
        juoksuButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("Nappia painettu", "position " + R.id.juoksuButton + " clicked!");
                Intent nextActivity = new Intent(MainActivity.this, LiikuntavuorotListattunaActivity.class);
                nextActivity.putExtra(EXTRA2, R.id.juoksuButton);
                startActivity(nextActivity);
            }
        });

        uintiButton = (ImageButton) findViewById(R.id.uintiButton);   //napin painallus avaa listanäkymän valitun lajin vuoroista ja laittaa juoksupojan matkaan
        uintiButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("Nappia painettu", "position " + R.id.uintiButton + " clicked!");
                Intent nextActivity = new Intent(MainActivity.this, LiikuntavuorotListattunaActivity.class);
                nextActivity.putExtra(EXTRA2, R.id.uintiButton);
                startActivity(nextActivity);
            }
        });

        nyrkkeilyButton = (ImageButton) findViewById(R.id.kamppailuButton);   //napin painallus avaa listanäkymän valitun lajin vuoroista ja laittaa juoksupojan matkaan
        nyrkkeilyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("Nappia painettu", "position " + R.id.kamppailuButton + " clicked!");
                Intent nextActivity = new Intent(MainActivity.this, LiikuntavuorotListattunaActivity.class);
                nextActivity.putExtra(EXTRA2, R.id.kamppailuButton);
                startActivity(nextActivity);
            }
        });

        joogaButton = (ImageButton) findViewById(R.id.kehoButton);   //napin painallus avaa listanäkymän valitun lajin vuoroista ja laittaa juoksupojan matkaan
        joogaButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("Nappia painettu", "position " + R.id.kehoButton + " clicked!");
                Intent nextActivity = new Intent(MainActivity.this, LiikuntavuorotListattunaActivity.class);
                nextActivity.putExtra(EXTRA2, R.id.kehoButton);
                startActivity(nextActivity);
            }
        });

        painoButton = (ImageButton) findViewById(R.id.painoButton);   //napin painallus avaa listanäkymän valitun lajin vuoroista ja laittaa juoksupojan matkaan
        painoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("Nappia painettu", "position " + R.id.painoButton + " clicked!");
                Intent nextActivity = new Intent(MainActivity.this, LiikuntavuorotListattunaActivity.class);
                nextActivity.putExtra(EXTRA2, R.id.painoButton);
                startActivity(nextActivity);
            }
        });

        palloiluButton = (ImageButton) findViewById(R.id.palloButton);   //napin painallus avaa listanäkymän valitun lajin vuoroista ja laittaa juoksupojan matkaan
        palloiluButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("Nappia painettu", "position " + R.id.palloButton + " clicked!");
                Intent nextActivity = new Intent(MainActivity.this, LiikuntavuorotListattunaActivity.class);
                nextActivity.putExtra(EXTRA2, R.id.palloButton);
                startActivity(nextActivity);
            }
        });

        pyorailyButton = (ImageButton) findViewById(R.id.pyorailyButton);   //napin painallus avaa listanäkymän valitun lajin vuoroista ja laittaa juoksupojan matkaan
        pyorailyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("Nappia painettu", "position " + R.id.pyorailyButton + " clicked!");
                Intent nextActivity = new Intent(MainActivity.this, LiikuntavuorotListattunaActivity.class);
                nextActivity.putExtra(EXTRA2, R.id.pyorailyButton);
                startActivity(nextActivity);
            }
        });

        tanssiButton = (ImageButton) findViewById(R.id.tanssiButton);   //napin painallus avaa listanäkymän valitun lajin vuoroista ja laittaa juoksupojan matkaan
        tanssiButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("Nappia painettu", "position " + R.id.tanssiButton + " clicked!");
                Intent nextActivity = new Intent(MainActivity.this, LiikuntavuorotListattunaActivity.class);
                nextActivity.putExtra(EXTRA2, R.id.tanssiButton);
                startActivity(nextActivity);
            }
        });

    }
}