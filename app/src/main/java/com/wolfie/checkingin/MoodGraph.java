package com.wolfie.checkingin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MoodGraph extends AppCompatActivity {
    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_graph);
        barChart = findViewById(R.id.barGraphMoodTracker);
        sharedPreferences = getSharedPreferences("com.example.moodtracker", Context.MODE_PRIVATE);
        int rad_counter = sharedPreferences.getInt("rad_counter", 0);
        int good_counter = sharedPreferences.getInt("good_counter", 0);
        int meh_counter = sharedPreferences.getInt("meh_counter", 0);
        int bad_counter = sharedPreferences.getInt("bad_counter", 0);
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1f, rad_counter));
        barEntries.add(new BarEntry(2f, good_counter));
        barEntries.add(new BarEntry(3f, meh_counter));
        barEntries.add(new BarEntry(4f, bad_counter ));
        barDataSet = new BarDataSet(barEntries, "Mood Count");
        barData = new BarData(barDataSet);
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);
        barChart.setData(barData);

    }
}
