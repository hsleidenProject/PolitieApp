package com.example.yanick.politieapp;

import android.graphics.Color;
import android.os.DropBoxManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.yanick.politieapp.Controller.ArtikelController;
import com.example.yanick.politieapp.Model.Catagorie;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;

public class PieChartActivity extends AppCompatActivity {

    private PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);


        pieChart = (PieChart)findViewById(R.id.chart);
        pieChart.setDescription("Aantal artikelen per categorie");
        pieChart.setTouchEnabled(false);
        pieChart.setDrawSliceText(true);
        pieChart.getLegend().setEnabled(false);
        pieChart.animateY(500, Easing.EasingOption.EaseInBounce);

        ArtikelController controller = new ArtikelController(this);

        ArrayList<Entry> counter = new ArrayList<>();
        counter.add(new Entry(controller.getArtikelCount(0), 0));
        counter.add(new Entry(controller.getArtikelCount(1), 1));
        counter.add(new Entry(controller.getArtikelCount(2), 2));
        counter.add(new Entry(controller.getArtikelCount(3), 3));
        counter.add(new Entry(controller.getArtikelCount(4), 4));
        counter.add(new Entry(controller.getArtikelCount(5), 5));

        PieDataSet pieDataSet = new PieDataSet(counter, "Aantal artikelen per categorie");
        pieDataSet.setColors(ColorTemplate.PASTEL_COLORS);

        ArrayList<String> catagorien = new ArrayList<>();
        catagorien.add(Catagorie.getTitel(0));
        catagorien.add(Catagorie.getTitel(1));
        catagorien.add(Catagorie.getTitel(2));
        catagorien.add(Catagorie.getTitel(3));
        catagorien.add(Catagorie.getTitel(4));
        catagorien.add(Catagorie.getTitel(5));

        PieData pieData = new PieData(catagorien, pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }
}
