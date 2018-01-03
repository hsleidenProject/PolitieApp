package com.example.yanick.politieapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/*
a) De studenten leveren de projectfolder (van Android Studio) op als zip bestand.
b) Er wordt een link naar hun GIT Repository aangeleverd – dit is onderdeel van het verslag.
c) Er wordt een werkende versie van de app (een APK-bestand) aangeleverd.
d) De app wordt getoond aan een begeleider – de app mag dan niet crashen.


 Gezamelijk
 1) Een productverslag met screenshots van alle schermen. Hier staat beschreven hoe de app werkt en welke
    (on)mogelijkheden de app heeft. Verder bevat het productverslag o.a. welke material design principes zijn
    toegepast, de wireframes die bij het ontwerpen van de app zijn gemaakt, op welke versie van de Android
    SDK is ontwikkeld, in hoeverre het MAVEN build script is aangepast voor de applicatie, screenshots van de
    network statistics, CPU-load en memory usage opgenomen uit de DDMS.
 2) Een beschrijving van de gemaakte interface elementen, zoals buttons, invoervelden, toast msg en/of
    snackbars, ListViews, hamburger menu’s, data visualisatie, gebruik van fragments, gebruik van parameter
    passing, in hoeverre de app off-line kan werken, e.a.
 3) Beschrijving van de REST API mogelijkheden. Welke calls kan de API afhandelen, hoe werkt de API, waar
    wordt de data opgeslagen. Waarom is er gekozen voor deze manier van dataopslag.
 4) Bronnenlijst van alle gebruikte websites, literatuur en andere bronnen.

 Individueel
 1) De student beschrijft hoe de leerdoelen van de module zijn behaald.
 2) De link naar de GIT repository met een beschrijving van de gebruikte branches. De student beschrijft
    welke onderdelen hij heeft gemaakt. Dit is terug te vinden in de branches van de GIT-omgeving.
 3) Reflectie over de samenwerking en het leerproces van de student.
 4) Aanbeveling over de module op inhoudelijk gebied: de student adviseert welke onderwerpen van
    applicatieontwikkeling moeten blijven in het aangeboden onderwijs en welke onderwerpen wenselijk zijn
    die niet zijn aangeboden, inclusief relevante verwijzingen naar ondersteunende artikelen.


 Eindeisen
    -Student ontwerpt en ontwikkelt een applicatie met inbegrip van dataopslag.
    -Student begrijpt versioning systematiek en gebruikt deze voor de opdracht.
    -Student werkt met de belangrijkste tools binnen een ontwikkelomgeving.
    -Student maakt verschillende interface elementen voor een app.
    -Student slaat data van de app op.
    -Student beschrijft zijn app in een verslag
    -Student richt een API in voor gebruik met de app.*/


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
