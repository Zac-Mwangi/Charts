package com.example.charts;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    BarChart barChart;
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barChart = findViewById(R.id.bar_chart);
        pieChart = findViewById(R.id.pie_chart);

        //initialize array list
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        ArrayList<PieEntry> pieEntries = new ArrayList<>();

        //use for loop
        for(int i = 1; i<10 ; i++){
            //convert to float

            float value = (float)(i*7.0/i);

            //initialize bar chart entry
            BarEntry barEntry = new BarEntry(i,value);

            //initialize pie chart entry
            PieEntry pieEntry = new PieEntry(i,value);

            //add value in array list
            barEntries.add(barEntry);
            pieEntries.add(pieEntry);
        }

        //initialize bar dataset
        BarDataSet barDataSet = new BarDataSet(barEntries,"Employees");
        //set color
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        //hide draw value
        barDataSet.setDrawValues(false);
        //set bar data
        barChart.setData(new BarData(barDataSet));
        //set animation
        barChart.animateY(1000);
        //set description text and color
        barChart.getDescription().setText("Employees Chart");
        barChart.getDescription().setTextColor(Color.BLUE);

        //initialize pie data set
        PieDataSet pieDataSet = new PieDataSet(pieEntries, "Student");
        //set color
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        //set pie data
        pieChart.setData(new PieData(pieDataSet));
        //set animation
        pieChart.animateXY(1000,1000);
        //Hide description
        pieChart.getDescription().setEnabled(false);
    }
}