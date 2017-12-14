package com.example.mt2c4.doodlz;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    //    MediaPlayer bgMusic;
    MediaPlayer bgMusic = new MediaPlayer();
    Boolean bgMusic_state;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        int screenSize =
                getResources().getConfiguration().screenLayout &
                        Configuration.SCREENLAYOUT_SIZE_MASK;

        if (screenSize == Configuration.SCREENLAYOUT_SIZE_XLARGE)
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        else
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


//        //music
//        bgMusic = MediaPlayer.create(this, R.raw.bgmusic);
//
//    protected void musicPlay() {
//        bgMusic.reset();
//        bgMusic.setLooping(true);
//        bgMusic.start();
//    }
//
//    protected void musicStop() {
//        bgMusic.stop();
//    }
//
//    public Boolean getBgMusic_state() {
//        return bgMusic_state;
//    }
//
//    public void setBgMusic_state(Boolean bgMusic_state) {
//        this.bgMusic_state = bgMusic_state;
//    }

    //setBgMusic_state(true);
}


    @Override
    public void onPause() {
        super.onPause();
        bgMusic.release();
    }


}
