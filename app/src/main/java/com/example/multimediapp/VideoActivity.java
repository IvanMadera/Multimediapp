package com.example.multimediapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {
    //Relacionado a la reproducción de algun video

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        VideoView videoView = findViewById(R.id.vview);

        String origen = "android.resource://"+getPackageName()+"/"+R.raw.spiderman;
        Uri uri = Uri.parse(origen);
        videoView.setVideoURI(uri);

        MediaController controlador = new MediaController(this);
        videoView.setMediaController(controlador);
        controlador.setAnchorView(videoView);
    }
}