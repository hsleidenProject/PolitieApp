package com.example.yanick.politieapp.Model;

/**
 * Created by 0x000000 on 3-1-2018.
 */

public class Artikel {

    private String titel;
    private String tekst;
    private Long datum;
    private int catagorie;

    public String getTitel() {
        return titel;
    }

    public String getTekst() {
        return tekst;
    }

    public int getCatagorie() { return catagorie; }

    public String getDatum() {
        //TODO: Timestamp omzetten naar datum string

        return "Uninplmeented function";
    }


    public Artikel(String titel, String tekst, Long datum, int catagorie) {
        this.titel = titel;
        this.tekst = tekst;
        this.datum = datum;
        this.catagorie = catagorie;
    }
}