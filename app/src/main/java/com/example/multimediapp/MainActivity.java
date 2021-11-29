package com.example.multimediapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnImage, btnVoice, btnVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnImage = findViewById(R.id.btnImage);
        btnVoice = findViewById(R.id.btnVoice);
        btnVideo = findViewById(R.id.btnVideo);

        btnImage.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  startActivity(new Intent(MainActivity.this, ImageActivity.class));
              }
          }
        );

        btnVoice.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainActivity.this, VoiceActivity.class));
                }
            }
        );

        btnVideo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainActivity.this, VideoActivity.class));
                }
            }
        );
    }
}