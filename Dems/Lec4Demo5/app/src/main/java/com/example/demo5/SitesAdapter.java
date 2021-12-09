package com.example.demo5;

import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;

import java.util.List;

public class SitesAdapter extends BaseAdapter {
    List<String> SitesNamesList;
    List<Integer> SitesPicsList;

    public SitesAdapter(List<String> sitesNamesList, List<Integer> sitesPicsList) {
        SitesNamesList = sitesNamesList;
        SitesPicsList = sitesPicsList;
    }

    //You may write a method to change the data of this adapter object at any time
    //Note that you must call NotifyDataSetChanged() method whenever data changes

    @Override
    public int getCount() {
        //return the size of the data
        return SitesNamesList.size();
    }

    @Override
    public String getItem(int i) {

        return SitesNamesList.get(i);
    }

    @Override
    public long getItemId(int i) {

        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //is responsible for populating the ith (positionth) view in the adapter using the data (list of n elements) and the external
        //layout for each item that we have created
        if (view == null) {
           //inflate the external layout and assign the layout view to convertView
            LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
            view = layoutInflater.inflate(R.layout.layout_siteitem, viewGroup,false);
        }
        TextView txtViewSite = view.findViewById(R.id.txtViewSiteItem);
        txtViewSite.setText(SitesNamesList.get(i)); //populates text view with text from ith element in the data

        Drawable img = ResourcesCompat.getDrawable(viewGroup.getResources(), SitesPicsList.get(i), viewGroup.getContext().getTheme());

        img.setBounds(0, 0, 80, 80); //default bounds for drawable objxcect is 0,0,0,0

        //setting drawables for text view
        txtViewSite.setCompoundDrawables(img, null, null, null);
        txtViewSite.setCompoundDrawablePadding(8); //spacing around drawable image between image and margin, and image and text
        txtViewSite.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        return view;
    }
}
