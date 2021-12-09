package com.example.lec4demo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "WeightApp";
    RadioGroup radGroupConvType;
    EditText editTextInputWeight;
    Button btnConvertWeight;
    TextView txtViewResults;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setLogo(R.mipmap.ic_launcher_wt_round);
        actionBar.setDisplayShowTitleEnabled(false); //you could remove the title altogether
        actionBar.setTitle(R.string.titleWeightC);*/

        radGroupConvType = findViewById(R.id.radGroupConvType);
        editTextInputWeight = findViewById(R.id.editTextInputWeight);
        btnConvertWeight = findViewById(R.id.btnConvertWeight);
        txtViewResults = findViewById(R.id.txtViewResults);

        btnConvertWeight.setOnClickListener((View view) -> {
            if (radGroupConvType.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "Please select conversion type", Toast.LENGTH_SHORT).show();
            } else if (editTextInputWeight.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please enter input weight", Toast.LENGTH_SHORT).show();

            } else {
                double inputWeight;
                double outputWeight = 0;
                try {
                    inputWeight = Double.parseDouble(editTextInputWeight.getText().toString());

                    //if lbs to kgs conversion, input weight cannot be > 1000
                    //if kgs to lbs weight cannot be > 500, cannot be < 0
                    //conv. rate 1 Kg = 2.2 Lbs
                    //txtView Results should have: input weight (units) == output weight (appropriate units)

                    if (inputWeight < 0) {
                        //display toast saying input weight cannot be negative
                        Toast.makeText(this, "Input weight cannot be negative", Toast.LENGTH_SHORT).show();
                        txtViewResults.setText("");

                    } else if (radGroupConvType.getCheckedRadioButtonId() == R.id.radioBtnLbsToKgs) {
                        //this is entered if used has checked LBs to Kgs radio button in the radio group
                        if (inputWeight > 1000) {
                            Toast.makeText(this, "Wt in pounds cannot be > 1000", Toast.LENGTH_SHORT).show();
                            txtViewResults.setText("");
                        } else {
                            outputWeight = inputWeight/2.2;
                            txtViewResults.setText(String.format("Converted Weight: %.2f Kgs", outputWeight));
                        }
                    } else if ((radGroupConvType.getCheckedRadioButtonId() == R.id.radioBtnKgsToLbs)) {
                        if (inputWeight > 500) {
                            Toast.makeText(this, "Weight in Kgs cannot be greater than 500", Toast.LENGTH_SHORT).show();
                            txtViewResults.setText("");
                        } else {
                            outputWeight = inputWeight*2.2;
                            txtViewResults.setText(String.format("Converted Weight: %.2f Lbs", outputWeight));
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    //Log.e(TAG, e.getMessage()); //add the error log here and see if it appears in logcat
                    Log.e(TAG, e.getMessage());
                }
            }
        });

        radGroupConvType.setOnCheckedChangeListener((RadioGroup group, int checkedId) -> {
            //checkedId here represents the radio button that has been checked now
            RadioButton checkedRadBtn = findViewById(checkedId);
            String checkedRadioBtnText = checkedRadBtn.getText().toString();
            Toast.makeText(this, "Clicked on" + checkedRadioBtnText, Toast.LENGTH_SHORT).show();

            });
    }

    //Try this
    //Write a class method that validates user input and converts the weight
    //Call that method either in the button click listener or the Checked changed listener

    //Extension: Look at how to listen to edittext changes
}