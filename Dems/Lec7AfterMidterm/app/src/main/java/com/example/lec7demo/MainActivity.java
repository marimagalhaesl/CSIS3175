package com.example.lec7demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<GalleryImage> AnimalList = new ArrayList<>(); //empty list needs to be created before you can add things
    GridView gridViewImages;
    ImageView imgViewLarge;
    Toast currToast;
    int clickedItemInd = -1;

    //exercise: add splash activity with bunny image view that leads to main activity after 3 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddData();

        gridViewImages = findViewById(R.id.gridViewImages);
        imgViewLarge = findViewById(R.id.imgViewLarge);

        ImageAdapter imageAdapter = new ImageAdapter(AnimalList);
        gridViewImages.setAdapter(imageAdapter);
        gridViewImages.setNumColumns(3);
        gridViewImages.setHorizontalSpacing(8);
        gridViewImages.setVerticalSpacing(8);

        //GalleryImage myImage = imageAdapter.getItem(2); //use for getItem() method call

        gridViewImages.setOnItemClickListener((AdapterView<?> adapterView, View view, int i, long l) -> {

            clickedItemInd = i;
            imgViewLarge.setImageResource(AnimalList.get(i).getImgPic());
            if (currToast != null) {
                currToast.cancel();
            }
            currToast = Toast.makeText(MainActivity.this, "Species: " + AnimalList.get(i).getImgId(), Toast.LENGTH_LONG);
            currToast.show(); //dont forget to show the toast object after make text
        });

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        clickedItemInd = sharedPreferences.getInt("IMGIND", -1);

        //set up large image based on last clicked item on the previous activity run
        if (clickedItemInd != -1) {
            imgViewLarge.setImageResource(AnimalList.get(clickedItemInd).getImgPic());
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("IMGIND", clickedItemInd);
        editor.commit(); //don't forget to commit
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