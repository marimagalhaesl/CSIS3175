package com.example.demo5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.util.Linkify;
import android.widget.TextView;

public class NavyPierActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navy_pier);

        TextView txtViewNavyPierHours = findViewById(R.id.txtViewNavyPierDetails);
        txtViewNavyPierHours.setText("Click here for Navy Pier hours and admissions details" +
                "\nhttps://navypier.org/plan-your-visit/hours-and-admission/"); //at this point URL is not hypertexted

        Linkify.addLinks(txtViewNavyPierHours, Linkify.WEB_URLS);
    }
}