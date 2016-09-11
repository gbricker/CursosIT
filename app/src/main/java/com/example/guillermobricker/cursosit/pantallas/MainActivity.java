package com.example.guillermobricker.cursosit.pantallas;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.guillermobricker.cursosit.R;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView img =(ImageView)findViewById(R.id.ImgV_ITOK);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.anim_down);
        img.setAnimation(animation);

        progressBar= (ProgressBar)findViewById(R.id.progressBar);

        ObjectAnimator animator = ObjectAnimator.ofInt(progressBar,"progress",0,100);
        animator.setDuration(3000);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.start();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, CursosCard.class));//Abre siguiente activity
                finish();//Finaliza la actividad

            }
        },2000);


    }


}
