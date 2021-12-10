package com.example.mtforfinals.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mtforfinals.util.Item;
import com.example.mtforfinals.R;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends BaseAdapter {

    List<Item> itemList = new ArrayList<>();

    public ItemAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int i) {
        return itemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_list_view_item, viewGroup, false);
        }

        TextView textViewDestinationItem = view.findViewById(R.id.txtViewCategory);
        TextView textViewPriceItem = view.findViewById(R.id.txtViewCost);
        ImageView imageViewDestinationItem = view.findViewById(R.id.imageView);

        textViewDestinationItem.setText(itemList.get(i).getDestinationCategory());
        textViewPriceItem.setText(itemList.get(i).getPrice().toString());

        imageViewDestinationItem.setImageResource(itemList.get(i).getImageCategory());

        return view;
    }
}
