package com.example.demo5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listViewSites;

    List<String> ChicagoSiteNames = new ArrayList<>(Arrays.asList("Magnificent Mile", "Navy Pier","Art Institute"));
    List<Integer> ChicagoSitePics = new ArrayList<>(Arrays.asList(R.drawable.magmile, R.drawable.pier, R.drawable.artinst));

    //Better to maintain a List<SiteAttraction> objects. Class contains Name and Pic bound to each other
    List<SiteAttraction> ChicagoSites = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewSites = findViewById(R.id.listViewSites);

        //set up adapter object, which needs the data
        ArrayAdapter<String> sitesArrAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ChicagoSiteNames);
        listViewSites.setAdapter(sitesArrAdapter);

        //setting up custom Sites adapter
        SitesAdapter mySitesAdapter = new SitesAdapter(ChicagoSiteNames, ChicagoSitePics);
        listViewSites.setAdapter(mySitesAdapter);

        listViewSites.setOnItemClickListener(
                (AdapterView<?> adapterView, View view, int i, long l) -> {
                    switch (i) {
                        case 0:
                            //to open an external web link from the browser in the emulator
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.themagnificentmile.com/")));
                            break;
                        case 1:
                            startActivity(new Intent(MainActivity.this, NavyPierActivity.class));
                            break;
                        case 2:
                            startActivity(new Intent(MainActivity.this, ArtInstituteActivity.class));
                            break;
                    }
        });
    }

    //Write a class method to populate the list of sites objects and use list of sites as opposed to list of strings and integers
}