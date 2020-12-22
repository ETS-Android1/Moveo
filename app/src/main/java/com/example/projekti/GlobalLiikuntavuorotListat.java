package com.example.projekti;
import java.util.ArrayList;
import java.util.List;

/**
 * Luokka sisältää globaalit instanssit liikuntavuorolistoista
 * @author Kasperi Kiviluoma
 * @author Toni Franciskovic
 */

public class GlobalLiikuntavuorotListat {
    private static final GlobalLiikuntavuorotListat listaInstanssi = new GlobalLiikuntavuorotListat();
    private List<LiikuntaVuoro> juoksuLista, mailaLista, tyhjaLista, nyrkkeilyLista, uintiLista, palloiluLista, pyoraLista, joogaLista, pumppiLista, tanssiLista;

    /**
     * @return palauttaa instanssin joka sisältää kaikki listat
     */

    public static GlobalLiikuntavuorotListat haeInstanssi() {
        return listaInstanssi;
    }

    private GlobalLiikuntavuorotListat() {

        /* Luodaan listat ja lisätään sinne arvoja */

        this.juoksuLista = new ArrayList<>();
        juoksuLista.add(new LiikuntaVuoro("Juoksumatto", "Perjantai 9.10. klo 15.00-16.00", "ELIXIO Tapiola"));
        juoksuLista.add(new LiikuntaVuoro("Lenkkipolku intervalli", "Lauantai 10.10. klo 13.15-15.15", "ELIXIO Kauniainen"));

        this.mailaLista = new ArrayList<>();
        mailaLista.add(new LiikuntaVuoro("Sulkapallo", "Sunnuntai 11.10. klo 15.00-16.00", "Fressimpi Otaniemi"));
        mailaLista.add(new LiikuntaVuoro("Salibandy", "Maanantai 12.10. klo 16.00-17.00", "Fressimpi Jätkäsaari"));
        mailaLista.add(new LiikuntaVuoro("Tennis", "Lauantai 10.10. klo 17.00-18.00", "Fitness48Fourteen Leppävaara"));

        this.pumppiLista = new ArrayList<>();
        pumppiLista.add(new LiikuntaVuoro("Bodypump", "Maanantai 12.10. klo 14.30-15.00", "HardFit Lauttasaari"));

        this.nyrkkeilyLista = new ArrayList<>();
        nyrkkeilyLista.add(new LiikuntaVuoro("BodyCombat", "Tiistai 13.10. klo 15.30-17.00", "HardFit Tapiola"));

        this.uintiLista = new ArrayList<>();
        uintiLista.add(new LiikuntaVuoro("Vesijuoksu", "Lauantai 10.10. klo 14.00-15.00", "Kontulan uimahalli"));

        this.palloiluLista = new ArrayList<>();
        palloiluLista.add(new LiikuntaVuoro("Koripallo", "Perjantai 9.10. klo 17.30-19.00", "JuniSport Otaniemi"));

        this.pyoraLista = new ArrayList<>();
        pyoraLista.add(new LiikuntaVuoro("Spinning", "Perjantai 9.10. klo 12.30-15.00", "Moment Kuntoklubi Matinkylä"));

        this.joogaLista = new ArrayList<>();
        joogaLista.add(new LiikuntaVuoro("Jooga", "Lauantai 10.10. klo 13.30-15.00", "ELIXIO Tapiola"));

        this.tanssiLista = new ArrayList<>();
        tanssiLista.add(new LiikuntaVuoro("Zumba", "Maanantai 12.10. klo 15.00-16.00", "ELIXIO Otaniemi"));

        tyhjaLista = new ArrayList<LiikuntaVuoro>();
    }

    /**
     * Tarkistaa mitä nappia painettiin ja palauttaa napin mukaisen listan
     * @param  nappiIndeksi klikatun ImageButtonin ID.
     * @return palauttaa valitun listan.
     */

    public List<LiikuntaVuoro> haeOikeaLista(int nappiIndeksi) {
        List<LiikuntaVuoro> oikeaLista = tyhjaLista;

        if (nappiIndeksi == 2131165335) {
            oikeaLista = this.juoksuLista;
        } else if (nappiIndeksi == 2131165346) {
            oikeaLista = this.mailaLista;
        } else if (nappiIndeksi == 2131165367) {
            oikeaLista = this.pumppiLista;
        } else if (nappiIndeksi == 2131165336) {
            oikeaLista = this.nyrkkeilyLista;
        } else if (nappiIndeksi == 2131165466) {
            oikeaLista = this.uintiLista;
        } else if (nappiIndeksi == 2131165368) {
            oikeaLista = this.palloiluLista;
        } else if (nappiIndeksi == 2131165380) {
            oikeaLista = this.pyoraLista;
        } else if (nappiIndeksi == 2131165337) {
            oikeaLista = this.joogaLista;
        } else if (nappiIndeksi == 2131165438) {
            oikeaLista = this.tanssiLista;
        } else if (nappiIndeksi == 2131165329) {
        }
        return oikeaLista;
    }

    /**
     * Palauttaa listan tyhjaLista
     * @return List<LiikuntaVuoro>
     */

    public List<LiikuntaVuoro> haeTulevat() {
        return tyhjaLista;
    }
}