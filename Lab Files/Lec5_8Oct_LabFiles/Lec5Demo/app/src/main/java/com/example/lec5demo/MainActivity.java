package com.example.lec5demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listViewSites;

    List<String> ChicagoSiteNames =
            new ArrayList<>(Arrays.asList("Magnificient Mile","Navy Pier","Art Institute"));
    List<Integer> ChicagoSitePics =
            new ArrayList<>(Arrays.asList(R.drawable.magmile,R.drawable.pier,R.drawable.artinst));

    //Better to maintain a List<SiteAttraction> objects. Class contains Name and Pic bound to each other
    List<SiteAttraction> ChicagoSites = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewSites = findViewById(R.id.listViewSites);

        //set up adapter object, which needs the data
        ArrayAdapter<String> sitesArrAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,ChicagoSiteNames);
        listViewSites.setAdapter(sitesArrAdapter);

    }

    //write a class method to populate the list of sites objects and use
    //list of sites as opposed to list of strings and integers

}