package com.example.yanick.politieapp.Model;

/**
 * Created by 0x000000 on 3-1-2018.
 */

public class Catagorie {
    public static final int HERKKENING = 0;
    public static final int COMMUNICATIE = 1;
    public static final int VERDACHTE = 2;
    public static final int SLACHTOFFER = 3;
    public static final int GETUIGE_BETROKKENE = 4;
    public static final int DOORVERWIJZING = 5;

    public static String getTitel(int catagorie) {
        switch (catagorie) {
            case 0:
                return "Herkenning";
            case 1:
                return "Communicatie";
            case 2:
                return "Verdachte";
            case 3:
                return "Slachtoffer";
            case 4:
                return "Getuige / Betrokkenen";
            case 5:
                return "Doorverwijzing";
        }
        return "Onbekende catagorie";
    }

}
