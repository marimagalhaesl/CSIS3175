package com.example.lec6auddemo;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AudioAdapter extends BaseAdapter {
    List<String> SongNames;
    List<Integer> SongPics;

    int CurrentPlayInd = -1; //maintains info on currently playing position, private to the adapter, so you need getters and setters

    public AudioAdapter(List<String> songNames, List<Integer> songPics) {
        SongNames = songNames;
        SongPics = songPics;
    }

    public AudioAdapter(List<String> songNames, List<Integer> songPics, int currentPlayInd) {
        SongNames = songNames;
        SongPics = songPics;
        CurrentPlayInd = currentPlayInd;
    }

    public int getCurrentPlayInd() {
        return CurrentPlayInd;
    }

    public void setCurrentPlayInd(int currentPlayInd) {
        CurrentPlayInd = currentPlayInd;
        notifyDataSetChanged(); //responsible for notifying the adapter that data has changed, and that it must repopulated
    }

    @Override
    public int getCount() {
        return SongPics.size(); //hopefully both pics and names size is the same
    }

    @Override
    public String getItem(int position) {
        return SongNames.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.layout_song,parent,false);
        }

        TextView txtViewSong = convertView.findViewById(R.id.txtViewSongItem);
        ImageView imgViewSong = convertView.findViewById(R.id.imgViewSongItem);
        ImageView imgViewPlayPause = convertView.findViewById(R.id.imgViewPlayPause);

        txtViewSong.setText(SongNames.get(position)); //gets the positionth song string from the list (adapter data)
        txtViewSong.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        imgViewSong.setImageResource(SongPics.get(position));

        if (position == CurrentPlayInd){
            imgViewPlayPause.setImageResource(R.drawable.stop);
        } else{
            imgViewPlayPause.setImageResource(R.drawable.play);
        }

        return convertView;
    }
}
