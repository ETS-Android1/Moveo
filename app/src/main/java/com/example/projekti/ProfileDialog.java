package com.example.projekti;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

/**
 * Luokka sisältää profiilin tietojen muokkaamisen ja esittelyyn käytettäviä apuvälineitä
 * @author Aivan Vo
 * @author Kasperi Kiviluoma
 * @version 6.10/2020
 */

/**
 * Avaa profiilinäkymän päälle uuden näkymän, josta voi muokata profiilinäkymässä olevat tiedot
 *
 */

public class ProfileDialog extends AppCompatDialogFragment {
    private EditText editTxtNimi, editTxtIka, editTxtSukupuoli, editTxtSahkoposti, editTxtMaksutiedot;
    private ProfileDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.profiili_dialog, null);

        /**
         *  "Peruuta" nappia painamalla näkymä menee takaisin profiilinäkymään muuttamatta tietoja
         *  "Tallenna muutokset" nappia painamalla sovellus tottelee käskyä Applytext metodia, joka asettaa ja tallentaa tiedot profiilinäkymään
         */
        builder.setView(view)
                .setTitle("Profiilitiedot")
                .setNegativeButton("peruuta", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Tallenna muutokset", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String nimi = editTxtNimi.getText().toString();
                        String ika = editTxtIka.getText().toString();
                        String sukupuoli = editTxtSukupuoli.getText().toString();
                        String sahkoposti = editTxtSahkoposti.getText().toString();
                        String maksutiedot = editTxtMaksutiedot.getText().toString();
                        listener.applyTexts(nimi, ika, sukupuoli, sahkoposti, maksutiedot);
                    }
                });

        editTxtNimi = view.findViewById(R.id.editTxtNimi);
        editTxtIka = view.findViewById(R.id.editTxtIka);
        editTxtSukupuoli = view.findViewById(R.id.editTxtSukupuoli);
        editTxtSahkoposti = view.findViewById(R.id.editTxtSahkoposti);
        editTxtMaksutiedot = view.findViewById(R.id.editTxtMaksutiedot);

        return builder.create();
    }

    /**
     * syötetyt tiedot, kuten nimi, ikä yms. siirretään muokkausnäkymästä profiilinäkymään
     * @param  context, sovelluksen nykyinen tila
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (ProfileDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement ProfileDialogListener");
        }
    }

    public interface ProfileDialogListener {
        void applyTexts(String nimi, String ika, String sukupuoli, String sahkoposti, String maksutiedot);
    }
}