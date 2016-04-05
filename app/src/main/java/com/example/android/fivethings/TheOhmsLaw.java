package com.example.android.fivethings;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class TheOhmsLaw extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        requestWindowFeature(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_ohms_law);
    }
}
