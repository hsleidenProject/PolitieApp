package com.example.yanick.politieapp;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import com.example.yanick.politieapp.Controller.UpdateController;
import com.example.yanick.politieapp.Controller.*;
import com.example.yanick.politieapp.Model.Artikel;
import com.example.yanick.politieapp.Model.Catagorie;
import com.example.yanick.politieapp.Utils.MessageBox;

import static com.example.yanick.politieapp.R.id.cardView1;

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
    -Student richt een API in voor gebruik met de app.  */

public class MainActivity extends AppCompatActivity {

    List<CardView> cardViewList;

    private void MessageBox(String title, String message)
    {
        new MessageBox(this, title, message);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UpdateController.UpdateDatabase(100);
        init(this);


        Artikel artikel = new Artikel("Demo Titel", "<h2>Er vrij tien maar apen bron ze zijn</h2>\n" +
                "\n" +
                "<p>Nu bezorgden bezwarend verdiende om te ingenieur ongunstig brandhout. Witte ellen ook prijs langs eerst reden wel die per. Welks elk drong lange stuit loopt ploeg per had. Gronds er parijs noodig of de. Den bevel gayah rijen nam hun zij. Gebruiken zee besluiten dan bloeiende oog aardschok. Geval om nu steek waren er mogen goten al.</p>\n" +
                "\n" +
                "<p>Af concurrent onvermoeid ingesneden ad wantrouwen werktuigen en verzekeren. Te zullen gezond op aaneen omhoog zuiger vierde. Er twee voor op rijk eind is. Dikwijls toe dal levendig golconda langzaam schatten tin. Er personeel en de ingenieur eindelijk. Moest laten zware ik ze. Verlaten als opdrogen hen aandacht een dus.</p>\n" +
                "\n" +
                "<p>Bewijs kracht sterke far zal schuld eenige houden. Kooplieden al rijkdommen om nu vergissing ad. Besparing ingenieur wel dat als den eindelijk. Tot heuvels hielden mee sommige noodige bontste sarongs. Gevolgd opweegt wolfram er nu na ernstig de bevrijd. Besluiten gezuiverd aan opbrengst gas datzelfde. Hoogte gerust graven mooren gebied en bakjes op. En bakjes ze al binnen goping schaal nu weinig. Naam dier vier ten het. Maar goed erin dan land tin twee.</p>\n" +
                "\n" +
                "<p>Ze in plaatse kleeren vorming gesteld ad moesten. Zij verzamelen gas vruchtbaar ontginning insnijding. Brandhout volledige gebruiken de af vierkante en verkregen is behoorden. Naam zou liet bak even kant zelf rijk toe. Volledige beteekent inzamelen zal was gesmolten gebruiken. Vroeger en of gezocht gedaald ad planter al kamarat metalen. Stroeve weg voordat geweest dik wie opnieuw het.</p>\n" +
                "\n" +
                "<p>Mijnwerker te europeanen regelmatig de. Tijd de gaan er deel. Voorloopig caoutchouc op nu herkenbaar ingenieurs verwachten de op werkwijzen. Inspanning gewoonlijk ondernomen besproeien er al de ad. De er onderwoeld weelderige goudmijnen spoorwegen de te. Al ingezameld spoorwegen traliewerk te te mijnschool dergelijke. Bij begin geven kreeg zal tin wonen water. Voorschijn spoorwegen ver belangrijk zij plotseling getaxeerde geruineerd. Aanleiding monopolies ingesneden schoonheid besproeien ik de op georgetown. Monopolie singapore en financien gomboomen nu gezuiverd nabijheid.</p>\n" +
                "\n" +
                "<p>Naar ziet is doel geen voor gold op. En gewijzigd wonderwel na vreedzame. Handel nu bezoek de noodig. Beteekent bevolking bijgeloof mekongdal op meehelpen ad prachtige ze. Bescheiden monopolies tot ook wij aanleiding aan dweepzieke. Witte niets op en dient rente. Af ontgonnen in aanraking bijgeloof te uitrollen hoofdstad denkbeeld. Gebrachte de of te bereiding siameezen aardschok. Bevaarbaar des traliewerk een aan kongostaat. Wie stichting gedurende was honderden hun ook.</p>\n" +
                "\n" +
                "<p>Tweemaal mei menschen bak dan beletsel talrijke reiziger. Middellijn bevorderen dan interesten voorschijn smeltovens wat tot. Dieper zee zilver staten koeken men. Op deed ziet duim hout gaat de te. Heuvel zouden dan rijken een ziekte weg tot. Ik al koopman en nu planken vroeger gomboom vlakken. Vestigen op troepjes uitgeput af de atjehers.</p>\n" +
                "\n" +
                "<p>Procede gronden in bereikt de te verdere. Zeven steel is ugong op. Ingericht brandstof er te degelijke herhaling. Jungles af planten ontdekt op. Dal systemen dikwijls verlaten dit stampers. Steenen ad en gronden gelegen de. Voeten tengka een forten voeden afzien pinang zij lot dus.</p>\n" +
                "\n" +
                "<p>Weelderige ongunstige en of economisch losgemaakt vaartuigen goudmijnen. Ieder is op er onder jacht af. Rijen de zaken nu kinta zulke af. Die traliewerk getaxeerde als doorzoeken ingenieurs uitstekend onderwoeld. Ik dekt liep gaan ze er goud al zijn zulk. Werkt niets de naast perak te. Heuvel minste pinang streng daarom ik in.</p>\n" +
                "\n", (long)123123123, 1);


        Intent intent = new Intent(MainActivity.this, ArtikelAcitivty.class);
        intent.putExtra("title", artikel.getTitel());
        intent.putExtra("text", artikel.getTekst());
        intent.putExtra("datum", artikel.getDatum());
        intent.putExtra("catagorie", artikel.getCatagorie());
        startActivity(intent);
    }

    private void init(Context context)
    {
        this.cardViewList = new ArrayList<CardView>();
        this.cardViewList.add((CardView)findViewById(cardView1));
        this.cardViewList.add((CardView)findViewById(R.id.cardView2));
        this.cardViewList.add((CardView)findViewById(R.id.cardView3));
        this.cardViewList.add((CardView)findViewById(R.id.cardView4));
        this.cardViewList.add((CardView)findViewById(R.id.cardView5));
        this.cardViewList.add((CardView)findViewById(R.id.cardView6));

        for(int a = 0; a < this.cardViewList.size();a++)
        {
            CardView card = (CardView)this.cardViewList.get(a);
            card.setTag(a);

            //Test voor onClickListeners voor hoofdmenu
            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CardView card = (CardView)view;

                    //Start new activity with the catagorie
                    Intent intent = new Intent(MainActivity.this, CatShow.class);
                    intent.putExtra("category", String.valueOf(card.getTag()));
                    startActivity(intent);

                }
            });
        }
    }
}
