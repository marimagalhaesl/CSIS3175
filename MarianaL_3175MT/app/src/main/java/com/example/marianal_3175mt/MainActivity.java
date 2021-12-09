package com.example.marianal_3175mt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Integer> drawables = new ArrayList<>(Arrays.asList(R.drawable.hawaii, R.drawable.cancun, R.drawable.vienna));
    List<Integer> songRaws = new ArrayList<>(Arrays.asList(R.raw.hawaii, R.raw.cancun, R.raw.vienna));
    List<String> durationPackageName = new ArrayList<>(Arrays.asList("Single Day Package", "Three Day Package", "Seven Day Package"));
    List<Double> basePricePerDay = new ArrayList<>(Arrays.asList(200.99, 189.99, 349.99));
    List<Double> additionalPrice = new ArrayList<>(Arrays.asList(59.99, 75.99, 89.99));

    Spinner spinnerDestination;
    RadioGroup radGroupDuration;
    Button btnNext;
    EditText customerName;

    MediaPlayer mPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radGroupDuration = findViewById(R.id.radioGroupDuration);
        btnNext = findViewById(R.id.btnNext);
        customerName = findViewById(R.id.editTextCustomerName);

        btnNext.setOnClickListener((View view) -> {
                    if (customerName.getText().toString().isEmpty()) {
                        Toast.makeText(this, "Please enter customer name", Toast.LENGTH_SHORT).show();
                    }
                    if (radGroupDuration.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(this, "Please pick duration", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent bookingAct = new Intent(MainActivity.this, BookingActivity.class);
                        Bundle bundle = new Bundle();
                        //bundle.putString ("Customer Name", customerName);
                        bundle.putString("Destination Info", spinnerDestination.getSelectedItem().toString());
                        //bundle.putStringArrayList("Duration Package Name",);

                        //startActivity(BookingActivity);

                    }

                    radGroupDuration.setOnCheckedChangeListener((RadioGroup group, int checkedId) -> {
                        RadioButton checkedRadioBtn = findViewById(checkedId);
                        String checkedRadioBtnTxt = checkedRadioBtn.getText().toString();
                        int index = spinnerDestination.getSelectedItemPosition();
                        double basePricePerPerson;

                        switch (index) {
                            case 0:
                             basePricePerPerson = basePricePerDay.get(index) * 1;
                             break;
                            case 2:
                                basePricePerPerson = basePricePerDay.get(index) * 3;
                                break;
                            case 3:
                                basePricePerPerson = basePricePerDay.get(index) * 7;
                                break;
                        }

                    });

                }
        );


    }
}