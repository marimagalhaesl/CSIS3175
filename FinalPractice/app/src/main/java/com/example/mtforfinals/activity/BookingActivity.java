package com.example.mtforfinals.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.mtforfinals.util.Item;
import com.example.mtforfinals.R;
import com.example.mtforfinals.adapter.ItemAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookingActivity extends AppCompatActivity {

    //image list for vacation pics:
    List<Integer> imageList = new ArrayList<>(Arrays.asList(R.drawable.hawaii, R.drawable.cancun, R.drawable.vienna));

    //list of strings for destination category:
    List<String> destinationCategoryList = new ArrayList<>(Arrays.asList("Relaxing", "Family-friendly", "Adventurous"));

    //list of integers that represents category pics:
    List<Integer> imagesListCategory = new ArrayList<>(Arrays.asList(R.drawable.relaxing, R.drawable.family, R.drawable.adventure));

    //list of doubles to hold prices:
    List<Double> pricesList = new ArrayList<>(Arrays.asList(59.99, 75.99, 89.99));

    List<Item> itemList = new ArrayList<>();

    //UI components declared in order:
    private ImageView imgViewDestination;
    private EditText editTextNumPersons;
    private ListView listViewVacationType;
    private TextView txtViewVacationBookingSummary;

    //auxiliary variable for the application:
    String customerName;
    String destination;
    Integer duration;
    Double cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        try {
            customerName = getIntent().getExtras().getString("NAME");
            destination = getIntent().getExtras().getString("DESTINATION");
            duration = getIntent().getExtras().getInt("DURATION");
            cost = getIntent().getExtras().getDouble("COST");


        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //find UI elements by id, layout whatever..
        imgViewDestination = findViewById(R.id.imgViewDestination);
        if(destination.equals("Hawaii")) {
            imgViewDestination.setImageResource(imageList.get(0));
        } else if(destination.equals("Cancun")) {
            imgViewDestination.setImageResource(imageList.get(1));
        } else {
            imgViewDestination.setImageResource(imageList.get(2));
        }

        editTextNumPersons = findViewById(R.id.editTextNumPersons);
        txtViewVacationBookingSummary = findViewById(R.id.txtViewVacationBookingSummary);
        //adapter:
        PopulateItems();
        listViewVacationType = findViewById(R.id.listViewVacationType);
        ItemAdapter itemAdapter = new ItemAdapter(itemList);
        listViewVacationType.setAdapter(itemAdapter);

        listViewVacationType.setOnItemClickListener((adapterView, view, i, l) -> {
            if (editTextNumPersons.getText().toString().equals("")) {
                Toast.makeText(this, "please enter number of persons", Toast.LENGTH_SHORT).show();
            } else {
//                txtViewVacationBookingSummary.setText("Customer name: " + customerName +
//                        "\nDestination:" + destination +
//                        "\nDuration: " + duration +
//                        "\nVacation Type: " + itemList.get(i).getDestinationCategory() +
//                        "\nTotal price per person: " + (cost + itemList.get(i).getPrice()) +
//                        "\nNumber of persons: " + editTextNumPersons.getText().toString() +
//                        "\nTotal Cost: " + (Double) ((cost + itemList.get(i).getPrice()) * Integer.parseInt(editTextNumPersons.getText().toString())));
                Toast.makeText(this, "Customer name: " + customerName +
                        "\nDestination:" + destination +
                        "\nDuration: " + duration +
                        "\nVacation Type: " + itemList.get(i).getDestinationCategory() +
                        "\nTotal price per person: " + (cost + itemList.get(i).getPrice()) +
                        "\nNumber of persons: " + editTextNumPersons.getText().toString() +
                        "\nTotal Cost: " + (Double) ((cost + itemList.get(i).getPrice()) * Integer.parseInt(editTextNumPersons.getText().toString())), Toast.LENGTH_LONG).show();

            }

        });
    }

    private void PopulateItems() {
        for (int i = 0; i < imageList.size(); i++) {
            Item item = new Item (destinationCategoryList.get(i), imagesListCategory.get(i), pricesList.get(i));
            itemList.add(item);
        }
    }

}