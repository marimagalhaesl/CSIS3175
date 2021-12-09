package com.example.lec3demo;

import androidx.annotation.Dimension;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);


        try {
            Bundle myBundle = getIntent().getExtras(); //you may get the bundle
            double cost = getIntent().getExtras().getDouble("COST", 0);
            int numTix = getIntent().getExtras().getInt("NUMTIX", 0); //you may call get without default value
            String concertType = getIntent().getExtras().getString("TYPE"); //you may skip default value


            DecimalFormat df = new DecimalFormat("\u00A4#.##");

            String outputStr = "Concert Type: " + concertType + "\n"
                    + "Num Tix: " + numTix + "\n"
                    + "Total Cost: " + df.format(cost);

            TextView txtViewResults = findViewById(R.id.txtViewSummary);
            txtViewResults.setText(outputStr);
            txtViewResults.setTextSize(Dimension.SP, 24); //setting text size at run time

            //txtViewResults.setGravity(Gravity.CENTER); //this set horz and ver gravity to center
            txtViewResults.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL); //top to center alignment


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}