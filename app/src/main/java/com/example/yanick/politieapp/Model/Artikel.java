package com.example.yanick.politieapp.Model;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 0x000000 on 3-1-2018.
 */

public class Artikel {

    private String titel;
    private String tekst;
    private Long datum;
    private int catagorie;

    public Artikel(String titel, String tekst, Long datum, int catagorie) {
        this.titel = titel;
        this.tekst = tekst;
        this.datum = datum;
        this.catagorie = catagorie;

    }

    public String getTitel() {
        return titel;
    }

    public String getTekst() {
        return tekst;
    }

    public int getCatagorie() {
        return catagorie;
    }

    public long getRawDatum()
    {
        return datum;
    }

    public String getDatum() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        Date netDate = (new Date(this.datum));
        return sdf.format(netDate);
    }
}
