package com.example.yanick.politieapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yanick.politieapp.Controller.ArtikelController;
import com.example.yanick.politieapp.Model.Artikel;
import com.example.yanick.politieapp.Model.Catagorie;
import com.example.yanick.politieapp.Utils.MessageBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CatShow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_show);

        int catagorieID = Integer.valueOf(getIntent().getStringExtra("category"));


        TextView titel = (TextView) findViewById(R.id.textGrid);
        titel.setText(Catagorie.getTitel(Integer.valueOf(catagorieID)));


        ArtikelController controller = new ArtikelController(this);
        ArrayList<Artikel> artikelen = controller.getArtikelen(catagorieID);


        //new MessageBox(this, "Artikelcounter", String.valueOf(artikelen.size()) + " Artikelen gevonden in database!");
    }

}
