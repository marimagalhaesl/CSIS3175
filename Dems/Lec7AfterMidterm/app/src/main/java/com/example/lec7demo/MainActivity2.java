package com.example.lec7demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    //set up data in the same manner as main activity
    List<GalleryImage> AnimalList = new ArrayList<>(); //empty list needs to be created before you can add things
    ImageView imgViewLarge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        AddData();

        //instantiate recyclerview
        RecyclerView recyclerViewGallery = findViewById(R.id.recyclerViewImages);
        imgViewLarge = findViewById(R.id.imgViewLarge2);
        imgViewLarge.setImageResource(0);

        //setlayout manager for recycler view using gridlayout manager or linear layout object
        GridLayoutManager gm = new GridLayoutManager(this, 3);
        recyclerViewGallery.setLayoutManager(gm);

        //create adapter object for recycler view
        ImageRecyclerViewAdapter myRecyclerImageAdapter = new ImageRecyclerViewAdapter(AnimalList, new ImageRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int i) {
                imgViewLarge.setImageResource(AnimalList.get(i).getImgPic());
            }
        });

        //set adapter for recycler view
        recyclerViewGallery.setAdapter(myRecyclerImageAdapter);

        //then add click listeners to recycler view as needed, interface call backs


    }

    private void AddData() {
        AnimalList.add(new GalleryImage(101, "Gorilla", R.drawable.gorilla));
        AnimalList.add(new GalleryImage(102, "Panda", R.drawable.panda));
        AnimalList.add(new GalleryImage(103, "Eagle", R.drawable.eagle));
        AnimalList.add(new GalleryImage(104, "Panther", R.drawable.panther));
        AnimalList.add(new GalleryImage(105, "Polar Bear", R.drawable.polar));
        AnimalList.add(new GalleryImage(106, "Elephant", R.drawable.elephant));

    }
}