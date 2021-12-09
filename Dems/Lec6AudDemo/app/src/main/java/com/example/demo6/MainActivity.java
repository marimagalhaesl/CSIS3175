package com.example.demo6;

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
    List<String> songNames = new ArrayList<>(Arrays.asList("Bag Pipes", "Ukelele", "Drums"));
    List<Integer> songPics = new ArrayList<>(Arrays.asList(R.drawable.bagpipes, R.drawable.ukulele, R.drawable.drums));

    //Maintain raw files for audio
    List<Integer> songRaws = new ArrayList<>(Arrays.asList(R.raw.bagpipes, R.raw.ukulele, R.raw.drums));

    MediaPlayer mPlayer = null; //using one media player object to play the current song



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listViewSongs = findViewById(R.id.listViewSongs);
        AudioAdapter myAudioAdapter = new AudioAdapter(songNames, songPics);
        listViewSongs.setAdapter(myAudioAdapter);

        //At this point the UI look for the music player should be complete

        listViewSongs.setOnItemClickListener((AdapterView<?> adapterView, View view, int i, long l) -> {

            //if there is a song that is currently playing, you want to stop that before moving on to play the clicked item

            if (mPlayer != null && mPlayer.isPlaying()) {
                mPlayer.stop();
            }


            if (myAudioAdapter.getCurrentPlayIndex() == i) {
                myAudioAdapter.setCurrentPlayIndex(-1);
                //here you do not stop the song again because it would have entered the previous if block
            } else {
                myAudioAdapter.setCurrentPlayIndex(i);
                //we want to play a new song at this point
                mPlayer = MediaPlayer.create(MainActivity.this, songRaws.get(i));
                //create method automatically prepares the raw file
                mPlayer.start();
            }
        });

        mPlayer.setOnCompletionListener((MediaPlayer mediaPlayer) -> {
           //when the song completes change icon back to play
           myAudioAdapter.setCurrentPlayIndex(-1);

           /*you may also prepare an mplayer object for the next time it is played
            try {
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }*/

        });
    }
}