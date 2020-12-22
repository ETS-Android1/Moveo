package com.example.projekti;

/**
 * Luokassa luodaan LiikuntaVuoro-oliot.
 * @author Kasperi Kiviluoma
 */

public class LiikuntaVuoro {

    private String nimi;
    private String aika;
    private String paikka;

    /**
     * Luo olion, jolla on nimi, aika ja paikka.
     * @param nimi Liikuntavuoron nimi.
     * @param aika Liikuntavuoron ajankohta.
     * @param paikka Liikuntavuoron sijainti
     */

    public LiikuntaVuoro(String nimi, String aika, String paikka) {

        this.nimi = nimi;
        this.aika = aika;
        this.paikka = paikka;

    }

    /**
     * Palauttaa olion nimen, ajan ja paikan.
     * @return String liikuntavuoron tiedot koottuna yhteen.
     */

    @Override
    public String toString() {
        return this.nimi+"\n"+this.aika+"\n"+this.paikka;
    }
}