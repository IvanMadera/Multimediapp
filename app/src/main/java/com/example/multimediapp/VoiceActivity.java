package com.example.multimediapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class VoiceActivity extends AppCompatActivity {
    //Relacionado a la grabación de voz
    private MediaRecorder grabacion;
    private String archivoSalida = null;
    Button btnrec, btnplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);

        btnrec = (Button)findViewById(R.id.btnrec);
        btnplay = (Button)findViewById(R.id.btnplay);

        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(VoiceActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO}, 1000);
        }

        btnrec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(grabacion == null){
                    archivoSalida = getExternalFilesDir(null).getAbsolutePath() + "/Grabacion.mp3";
                    grabacion = new MediaRecorder();
                    grabacion.setAudioSource(MediaRecorder.AudioSource.MIC);
                    grabacion.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                    grabacion.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                    grabacion.setOutputFile(archivoSalida);

                    try{
                        grabacion.prepare();
                        grabacion.start();
                    } catch (IOException e){
                    }

                    btnrec.setBackgroundResource(R.drawable.rec);
                    Toast.makeText(getApplicationContext(), "Grabando...", Toast.LENGTH_SHORT).show();
                } else if(grabacion != null){
                    grabacion.stop();
                    grabacion.release();
                    grabacion = null;
                    btnrec.setBackgroundResource(R.drawable.btnstop);
                    Toast.makeText(getApplicationContext(), "Grabacion finalizada", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setDataSource(archivoSalida);
                    mediaPlayer.prepare();
                } catch (IOException e){
                }

                mediaPlayer.start();
                Toast.makeText(getApplicationContext(), "Reproduciendo audio", Toast.LENGTH_SHORT).show();
            }
        });
    }

}