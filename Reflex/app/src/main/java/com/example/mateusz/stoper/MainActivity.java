package com.example.mateusz.stoper;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    Chronometer chronometer;
    private long pauseOffset;
    private boolean running;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        chronometer = findViewById(R.id.chronometer);
    }
        public void startChronometer(View v){
            if (!running) {
                chronometer.setBase(SystemClock.elapsedRealtime()- pauseOffset);
                chronometer.start();
                running = true;
            }
        }


        public void pauseChronometer(View v) {
            if (running) {
                chronometer.stop();
                pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
                running = false;
            }
        }
    public void resetChronometer(View v) {

        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseOffset = 0;
    }
}