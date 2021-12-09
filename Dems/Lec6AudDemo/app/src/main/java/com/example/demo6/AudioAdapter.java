package com.example.demo6;

import android.media.Image;
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

    int currentPlayIndex = -1; //maintains info on currently playing position, private to the adapter, so you need getters and setters

    public AudioAdapter(List<String> songNames, List<Integer> songPics, int currentPlayIndex) {
        SongNames = songNames;
        SongPics = songPics;
        this.currentPlayIndex = currentPlayIndex;
    }

    public AudioAdapter(List<String> songNames, List<Integer> songPics) {
        SongNames = songNames;
        SongPics = songPics;
    }

    public int getCurrentPlayIndex() {
        return currentPlayIndex;
    }

    public void setCurrentPlayIndex(int currentPlayIndex) {
        this.currentPlayIndex = currentPlayIndex;
        notifyDataSetChanged(); //responsible for notifying the adapter that data has changed, and that it must be repopulated
    }

    @Override
    public int getCount() {
        return SongPics.size(); //hopefully both pics and names size is the same
    }

    @Override
    public String getItem(int i) {
        return SongNames.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_song, viewGroup, false);
        }

        TextView txtViewSong = view.findViewById(R.id.txtViewSongItem);
        ImageView imgViewSong = view.findViewById(R.id.imgViewSongItem);
        ImageView imgViewPlayPause = view.findViewById(R.id.imgViewPlayPause);

        txtViewSong.setText(SongNames.get(i)); //gets the positionth song string from the list (adapter data)
        txtViewSong.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        imgViewSong.setImageResource(SongPics.get(i));


        if (i == currentPlayIndex) {
            imgViewPlayPause.setImageResource(R.drawable.stop);
        } else {
            imgViewPlayPause.setImageResource(R.drawable.play);
        }
        return view;
    }
}
