package com.example.yanick.politieapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.example.yanick.politieapp.Controller.ArtikelController;
import com.example.yanick.politieapp.Model.Artikel;
import com.example.yanick.politieapp.Model.Catagorie;
import com.example.yanick.politieapp.Utils.MessageBox;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ArtikelAcitivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artikel_acitivty);

        TextView title = (TextView) findViewById(R.id.textView1);
        TextView header = (TextView) findViewById(R.id.textView2);
        TextView tekst = (TextView) findViewById(R.id.textView3);

        title.setText(getIntent().getStringExtra("title"));
        header.setText(getIntent().getStringExtra("datum"));
        tekst.setText(Html.fromHtml(getIntent().getStringExtra("text")));

    }
}
