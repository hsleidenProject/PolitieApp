package com.example.yanick.politieapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yanick.politieapp.Controller.ArtikelController;
import com.example.yanick.politieapp.Model.Artikel;
import com.example.yanick.politieapp.Model.Catagorie;
import com.example.yanick.politieapp.Utils.MessageBox;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CatShow extends AppCompatActivity {


    private ArrayList<Artikel> artikelen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_show);

        int catagorieID = Integer.valueOf(getIntent().getStringExtra("category"));


        TextView titel = (TextView) findViewById(R.id.textGrid);
        titel.setText(Catagorie.getTitel(Integer.valueOf(catagorieID)));


        ArtikelController controller = new ArtikelController(this);
        artikelen = controller.getArtikelen(catagorieID);

        ArrayList<String> titels = new ArrayList<>();

        for(Artikel artikel : artikelen)
        {
            titels.add(artikel.getTitel());
        }


        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, titels )
        {
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                /// Get the Item from ListView
                View view = super.getView(position, convertView, parent);
                TextView tv = (TextView) view.findViewById(android.R.id.text1);
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,25);
                tv.setTextColor(0xff151dff);
                return view;
            }
        };

        ListView listView = (ListView)findViewById(R.id.listview);
        listView.setAdapter(adapter);
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
