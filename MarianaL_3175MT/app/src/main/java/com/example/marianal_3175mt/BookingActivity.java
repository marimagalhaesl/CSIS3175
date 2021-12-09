package com.example.marianal_3175mt;

import androidx.annotation.Dimension;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

import java.text.DecimalFormat;

public class BookingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);


        Bundle myBundle = getIntent().getExtras();
        String CustomerName = getIntent().getExtras().getString("Customer Name", "");
        String DestinationInfo = getIntent().getExtras().getString("Destination Info", "");
        String PackageName = getIntent().getExtras().getString("Package Name");

        String outputStr = "Customer Name: " + CustomerName + "\n"
                + "Destination: " + DestinationInfo + "\n"
                + "Duration: " + PackageName;

        TextView txtViewResults = findViewById(R.id.txtViewVacationBookingSummary);
        txtViewResults.setText(outputStr);
        txtViewResults.setTextSize(Dimension.SP, 24);

        txtViewResults.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);

    }

}