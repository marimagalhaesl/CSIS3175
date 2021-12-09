package com.example.lec7demo;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

public class ImageAdapter extends BaseAdapter {
    List<GalleryImage> imageList;

    public ImageAdapter(List<GalleryImage> imageList) {
        this.imageList = imageList;
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public Object getItem(int i) {
        return imageList.get(i);
    }

    @Override
    public long getItemId(int i) {
        //typically returns primary key based id from the data base
        return imageList.get(i).getImgId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            ImageView imgViewItem = new ImageView (viewGroup.getContext());
            imgViewItem.setLayoutParams(new ViewGroup.LayoutParams(GridView.AUTO_FIT, 120));
            imgViewItem.setBackgroundColor(Color.LTGRAY);
            imgViewItem.setImageResource(imageList.get(i).getImgPic());
            view = imgViewItem;
        }
        return view;
    }
}
