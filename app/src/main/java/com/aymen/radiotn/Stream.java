package com.aymen.radiotn;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class Stream extends AppCompatActivity {

    String name = "";
    String audioUrl ="" ;
    String imageUrl ="" ;
    Boolean isPLAYING = false ;
    ImageView play ;
    MediaPlayer mp ;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stream);

        Intent in = getIntent();
        Bundle b = in.getExtras();


        name = b.getString("name");
        audioUrl = b.getString("audioUrl");
        imageUrl =b.getString("imageUrl");
        play = (ImageView) findViewById(R.id.pauseButton) ;

        mp = new MediaPlayer();
        try {
            mp.setDataSource(audioUrl);
            mp.prepare();
            mp.start();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }






    }




}
