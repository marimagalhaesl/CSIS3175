package com.example.lec5demo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class SitesAdapter extends BaseAdapter {
    List<String> SitesNamesList;
    List<Integer> SitesPicsList;

    public SitesAdapter(List<String> sitesNamesList, List<Integer> sitesPicsList) {
        SitesNamesList = sitesNamesList;
        SitesPicsList = sitesPicsList;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //is responsible for populating the ith (positionth) view in the adapter using
        //the data (list of n elements) and the external layout for each item that
        //we have created

        return null;
    }
}
