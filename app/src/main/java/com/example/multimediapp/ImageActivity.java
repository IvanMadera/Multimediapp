package com.example.multimediapp;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {
    //Relacionado a la imagen vectorial animada
    Button btnanimacion;
    ImageView imagev;
    ObjectAnimator animatorRotation;
    long animationDuration = 3000;
    AnimatorSet animatorSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        animatorSet = new AnimatorSet();
        btnanimacion = findViewById(R.id.btnanimacion);
        imagev = findViewById(R.id.imagev);

        btnanimacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animatorRotation = ObjectAnimator.ofFloat(imagev, "rotation",0f, 720f);
                animatorRotation.setDuration(animationDuration);
                AnimatorSet animatorSetRotator = new AnimatorSet();
                animatorSetRotator.playTogether(animatorRotation);
                animatorSetRotator.start();
            }
        });
    }
}