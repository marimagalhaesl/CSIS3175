package com.example.lec6auddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> SongNames = new ArrayList<>(Arrays.asList("Bag Pipes","Ukelele","Drums"));
    List<Integer> SongPics = new ArrayList<>(Arrays.asList(R.drawable.bagpipes,
                                            R.drawable.ukulele,R.drawable.drums));

    //Maintain raw files for audio
    List<Integer> songRaws = new ArrayList<>(Arrays.asList(R.raw.bagpipes,R.raw.ukulele,R.raw.drums));
    MediaPlayer mPlayer = null; //using one media player object to play the current song


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listViewSongs = findViewById(R.id.listViewSongs);
        AudioAdapter myAudAdapter = new AudioAdapter(SongNames, SongPics);
        listViewSongs.setAdapter(myAudAdapter);

        //At this point the UI look for the music player should be complete

        //Set a value for Current Playing Ind
        //and see if that changes the data
        listViewSongs.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            //if there is a song that is playing, you want to stop that before moving on to play the clicked item
            if (mPlayer != null && mPlayer.isPlaying()) {
                mPlayer.stop();
            }

            if (myAudAdapter.getCurrentPlayInd() == position){
                myAudAdapter.setCurrentPlayInd(-1);
                //here you do not stop the song again because it would have entered the previous if block
            } else {
                myAudAdapter.setCurrentPlayInd(position);
                //we want to play a new song at this point
                mPlayer = MediaPlayer.create(MainActivity.this,songRaws.get(position));
                //create method automatically prepares the raw file
                mPlayer.start();
                mPlayer.setOnCompletionListener((MediaPlayer mp) -> {
                    //When the song completes
                    myAudAdapter.setCurrentPlayInd(-1);

                    //you may also prepare an mplayer object for the next time it is played
                    try {
                        mp.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        });


        //Try to add pause instead of stop image for currently play song, and pause it if clicked again,
        //and resume/start again if paused
        //if moving to a new item, then the previous item song must be stopped before starting the current one


    }
}