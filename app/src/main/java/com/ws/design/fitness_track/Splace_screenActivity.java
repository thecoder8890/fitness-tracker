package com.ws.design.fitness_track;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splace_screenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splace_screen);

        Thread background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for 5 seconds
                    sleep(2 * 1000);

                    Intent intent = new Intent(Splace_screenActivity.this, List_recycleActivity.class);
                    startActivity(intent);

                    // After 5 seconds redirect to another intent

                    //Remove activity
                    finish();

                } catch (Exception e) {

                }
            }
        };
        // start thread
        background.start();
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }
}
