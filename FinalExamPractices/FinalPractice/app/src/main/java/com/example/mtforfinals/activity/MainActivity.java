package com.example.mtforfinals.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mtforfinals.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    //image list for vacation pics:
    List<Integer> imageList = new ArrayList<>(Arrays.asList(R.drawable.hawaii, R.drawable.cancun, R.drawable.vienna));

    //string list for destinations name:
    List<String> destinationList = new ArrayList<>(Arrays.asList("Hawaii", "Cancun", "Vienna"));

    //list of doubles to hold prices:
    List<Double> pricesList = new ArrayList<>(Arrays.asList(200.99, 189.99, 349.99));

    //UI components declared in order:
    TextView txtViewTitle;
    EditText editTextCustomerName;
    Spinner spinnerDestination;
    RadioGroup radGroupDuration;
    RadioButton radButtonSingle;
    RadioButton radButtonThree;
    RadioButton radButtonSeven;
    TextView txtViewPricePerson;
    Button btnNext;

    //auxiliary variable for the application:
    Double basePricePerPerson = -1.0;
    Double BasePricePerPersonDay = -1.0;
    int numberOfDays = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find UI elements by id, layout whatever..
        txtViewTitle = findViewById(R.id.txtViewTtile);
        editTextCustomerName = findViewById(R.id.editTextCustomerName);
        spinnerDestination = findViewById(R.id.spinnerDestination);
        radGroupDuration = findViewById(R.id.radGroupDuration);
        radButtonSingle = findViewById(R.id.radButtonSingle);
        radButtonThree = findViewById(R.id.radButtonThree);
        radButtonSeven = findViewById(R.id.radButtonSeven);
        txtViewPricePerson = findViewById(R.id.txtViewBasePricePerson);
        btnNext = findViewById(R.id.btnNext);


        //prompt for spinner:
        spinnerDestination.setPrompt("Choose your destination:");

        //keep track of the radio button id within the radio group
        radGroupDuration.setOnCheckedChangeListener((radioGroup, i) -> {

            //keep track of the radio button for package selected:
            RadioButton checkedId = findViewById(i);

            //keep track of the destination:
            String destination = spinnerDestination.getSelectedItem().toString();


            //figure it out the base price of the destination based on the spinner:
            if (destination.equals("Hawaii")) {
                BasePricePerPersonDay = pricesList.get(0);
            }

            if (destination.equals("Cancun")) {
                BasePricePerPersonDay = pricesList.get(1);
            }

            if (destination.equals("Vienna")) {
                BasePricePerPersonDay = pricesList.get(2);
            }

            if (checkedId.getText().equals("Single Day Package")) {
                numberOfDays = 1;
            }

            if (checkedId.getText().equals("Three Days Package")) {
                numberOfDays = 3;
            }

            if (checkedId.getText().equals("Seven Days Package")) {
                numberOfDays = 7;
            }

            basePricePerPerson = BasePricePerPersonDay * numberOfDays;

            txtViewPricePerson.setText("Base Cost Per Person:" + NumberFormat.getCurrencyInstance(new Locale("en", "US"))
                    .format(basePricePerPerson));

            });


        btnNext.setOnClickListener(view -> {
            //check if client's name input is written:
            String customerName = editTextCustomerName.getText().toString();

            if (customerName.equals("")) {
                Toast.makeText(this, "Please enter customer name", Toast.LENGTH_SHORT).show();
                return;
            }

            if (radGroupDuration.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "Please pick duration package", Toast.LENGTH_SHORT).show();
                return;
            }

            // set intent:
            Intent bookingActivity = new Intent(MainActivity.this, BookingActivity.class);

            // send the bundle:
            bookingActivity.putExtra("NAME", customerName);
            bookingActivity.putExtra("DESTINATION", spinnerDestination.getSelectedItem().toString());
            bookingActivity.putExtra("DURATION", numberOfDays);
            bookingActivity.putExtra("COST", basePricePerPerson);

            startActivity(bookingActivity);
        });
    }
}