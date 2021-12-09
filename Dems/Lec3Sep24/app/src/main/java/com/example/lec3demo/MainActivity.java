package com.example.lec3demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerConcertType;
    EditText editTextNumTix; //cannot have access to the view until setContentView is called
    Button btnCalcCost;
    final String TAG = "Concert Dem";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //add log indicating app logic is starting
        Log.d(TAG, "Starting the logic for concert cost calculator...");

        btnCalcCost = findViewById(R.id.btnCalculateCost);
        editTextNumTix = findViewById(R.id.editTextNumTix);

        btnCalcCost.setOnClickListener((View view) -> {
            if (editTextNumTix.getText().toString().isEmpty()) {
                Log.d(TAG, "Number of tickets field is empty");
                Toast.makeText(this, "Please enter number of tickets", Toast.LENGTH_SHORT).show();
            } else {
                try {
                    int numTix = Integer.parseInt(editTextNumTix.getText().toString());
                    int index = spinnerConcertType.getSelectedItemPosition();
                    double cost = 0;
                    switch (index) {
                        case 0:
                            cost = numTix+79.99;
                            break;
                        case 1:
                            cost = numTix+69.99;
                            break;
                        case 2:
                            cost = numTix+59.99;
                            break;
                    }
                    //Create another empty activity ResultsActivity with a txtViewSummary

                    //Create an intent to start that activity
                    Intent myResults = new Intent(MainActivity.this,ResultsActivity.class);

                    //Put the data - numTix, cost and selected concert into the intent as a bundle
                    Bundle bundle = new Bundle();
                    bundle.putInt("NUMTIX", numTix);
                    bundle.putString("TYPE", spinnerConcertType.getSelectedItem().toString());
                    bundle.putDouble("COST", cost);
                    myResults.putExtras(bundle); //put the bundle into the intent


                    //Then start the next activity
                    startActivity(myResults); //at this point control leaves the MainActivity object


                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(this, "Please enter a whole number", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, e.getMessage()); //log displaying the exception object message
                }
            }
        });
    }
}