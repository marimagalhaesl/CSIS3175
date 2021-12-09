package com.example.lec2demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //Button btnShowRecipe; //findViewById cannot be called here

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //once this is done all the views can be instantiated in JAVA

       Button btnShowRecipe = findViewById(R.id.btnShowRecipe); //findViewById returns View object

        //btnShowRecipe = findViewById(R.id.btnShowRecipe);

        //startActivity(new Intent(this, RecipeActivity.class));

        btnShowRecipe.setOnClickListener((View view) -> {
            //start next activity
            startActivity(new Intent(MainActivity.this,RecipeActivity.class));
            //at this point control should move to RecipeActivity
        });
    }
    //other methods in this class will not have access to btnShowRecipe
}