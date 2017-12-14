package com.example.mt2c4.doodlz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import junit.framework.Protectable;

/**
 * Created by MT2C4 on 12/13/2017.
 */

public class Splash extends AppCompatActivity{
    private TextView spalsh_text;
    private ImageView splash_img;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        spalsh_text = (TextView) findViewById(R.id.splashTextView);
        splash_img = (ImageView) findViewById(R.id.splashImageView);
        Animation splash = AnimationUtils.loadAnimation(this, R.anim.splash_transition);
        spalsh_text.startAnimation(splash);
        splash_img.startAnimation(splash);


        final Intent i = new Intent(this, MainActivity.class);
        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(5000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };

                timer.start();
    }


}
