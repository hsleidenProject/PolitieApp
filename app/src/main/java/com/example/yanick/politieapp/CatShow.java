package com.example.yanick.politieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yanick.politieapp.Controller.ArtikelController;
import com.example.yanick.politieapp.Model.Artikel;
import com.example.yanick.politieapp.Model.Catagorie;

import java.util.ArrayList;

public class CatShow extends AppCompatActivity {


    private ArrayList<Artikel> artikelen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_show);

        TextView titel = (TextView) findViewById(R.id.textGrid);
        ListView listView = (ListView) findViewById(R.id.listview);

        ArtikelController controller = new ArtikelController(this);
        ArrayList<String> titels = new ArrayList<>();

        int catagorieID = Integer.valueOf(getIntent().getStringExtra("category"));

        //Titel
        titel.setText(Catagorie.getTitel(Integer.valueOf(catagorieID)));

        //Ophalen artikelen
        artikelen = controller.getArtikelen(catagorieID);

        //Artikelen omzetten naar lijst met titels
        for (Artikel artikel : artikelen) {
            titels.add(artikel.getTitel());
        }

        //Nieuwe adapter voor listView; fontsize/color wordt hier aangepast bij het opvragen van de View
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, titels) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View view = super.getView(position, convertView, parent);
                TextView tv = (TextView) view.findViewById(android.R.id.text1);
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
                tv.setTextColor(0xff000000);
                return view;
            }
        };

        //Nieuwe adapter koppelen aan ListView
        listView.setAdapter(adapter);

        //Klik afvangen, en doorsturen geselecteerd artikel naar volgende Activity.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Artikel artikel = artikelen.get(position);
                Intent intent = new Intent(CatShow.this, ArtikelAcitivty.class);
                intent.putExtra("title", artikel.getTitel());
                intent.putExtra("text", artikel.getTekst());
                intent.putExtra("datum", artikel.getDatum());
                intent.putExtra("catagorie", artikel.getCatagorie());
                startActivity(intent);
            }
        });
    }
}
