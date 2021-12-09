package com.example.lec7demo;

import android.graphics.Color;
import android.media.Image;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ImageRecyclerViewAdapter extends RecyclerView.Adapter<ImageRecyclerViewAdapter.ImageViewHolder> {

    List<GalleryImage> AnimalList;
    //click listener objects can be defined here
    OnItemClickListener onItemClickListener;

//    public ImageRecyclerViewAdapter(List<GalleryImage> animalList) {
//        AnimalList = animalList;
//    }

    public ImageRecyclerViewAdapter(List<GalleryImage> animalList, OnItemClickListener onItemClickListener) {
        AnimalList = animalList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ImageView imgViewItem = new ImageView(parent.getContext());
        imgViewItem.setLayoutParams(new ViewGroup.LayoutParams(120, 120));

        //onCreate can be used to inflate external layout as well
        //View view = View.inflate()

//        001: View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,parent,false);
//             ImageViewHolder imgViewHolderExt = new ImageView(view);


        //create holder object
        ImageViewHolder imgViewHolder =  new ImageViewHolder(imgViewItem);
        //        ImageViewHolder imgViewHolder =  new ImageViewHolder(view);

        imgViewHolder.itemImgView.setOnClickListener((View view) -> {
            imgViewHolder.itemView.setBackgroundColor(Color.LTGRAY);
            onItemClickListener.onItemClick(imgViewHolder.getAdapterPosition());

        });

        //EX1: As an exercise, turn only the clickede item to ltgray, rest goes to some default color

        return imgViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        //onBind used for populating the data
        holder.itemImgView.setImageResource(AnimalList.get(position).getImgPic());

        //EX1: set up a default color
    }

    @Override
    public int getItemCount() {
        //returns the size of the data
        return AnimalList.size();
    }

    //create an inner custom view holder class - before implementing the methods
    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImgView; //custom inner views needed to be accessed from the holder object

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImgView = (ImageView) itemView;
            //01: itemImgView = itemView.findViewById(R.id.imgViewItem); -only used if using external layout
        }
    }

    interface OnItemClickListener {
        void onItemClick (int i); //i corresponds to the index/position of the clicked item in the data
    }
}

