package com.example.joel.reflex_java;

import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button b_main, b_start;

    TextView tv_info;

    long startTime, endTime, currentTime, bestTime = 10000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b_start = (Button) findViewById(R.id.b_start);
        b_main = (Button) findViewById(R.id.b_main);

        tv_info = (TextView) findViewById(R.id.tv_info);

        b_start.setEnabled(true);
        b_main.setEnabled(false);

        tv_info.setText("BEST RESULT: " + bestTime + " ms");

        b_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b_start.setEnabled(false);
                b_main.setText("");

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startTime = System.currentTimeMillis();
                        b_main.setBackgroundColor
                                (ContextCompat.getColor(getApplicationContext(),R.color.blue));
                        b_main.setText("PRESS");

                        b_main.setEnabled(true);


                    }
                }, 2000);
            }
        });

        b_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                endTime = System.currentTimeMillis();
                currentTime = endTime - startTime;
                b_main.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.red));
                b_main.setText(currentTime + "ms");
                b_start.setEnabled(true);


                if (currentTime < bestTime) {
                    bestTime = currentTime;
                    tv_info.setText("BEST RESULT: " + bestTime + " ms");
                }

            }
        });






    }

}

