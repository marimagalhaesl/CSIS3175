package com.example.marianal_3175mt;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    List<String> destinationName;
    List<Integer> destinationPics;
    List<Double> destinationPrice;
    List<String> songNames;

    int CurrentPlaying = -1;

    public CustomAdapter(List<String> destinationName, List<Integer> destinationPics, List<Double> destinationPrice) {
        this.destinationName = destinationName;
        this.destinationPics = destinationPics;
        this.destinationPrice = destinationPrice;
    }

    public List<String> getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(List<String> destinationName) {
        this.destinationName = destinationName;
    }

    public List<Integer> getDestinationPics() {
        return destinationPics;
    }

    public void setDestinationPics(List<Integer> destinationPics) {
        this.destinationPics = destinationPics;
    }

    public List<Double> getDestinationPrice() {
        return destinationPrice;
    }

    public void setDestinationPrice(List<Double> destinationPrice) {
        this.destinationPrice = destinationPrice;
    }

    @Override
    public int getCount() {
        return destinationName.size();
    }

    @Override
    public Object getItem(int i) {
        return destinationName.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_vacation, viewGroup, false);
        }

        ImageView imgViewVacType = view.findViewById(R.id.imgViewVacType);
        TextView txtViewDescription = view.findViewById(R.id.txtViewDescription);
        TextView txtViewAddPrice = view.findViewById(R.id.txtViewAddCost);


        txtViewDescription.setText(songNames.get(i));
        txtViewDescription.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        imgViewVacType.setImageResource(destinationPics.get(i));
        

}

