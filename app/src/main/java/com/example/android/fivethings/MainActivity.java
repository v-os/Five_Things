package com.example.android.fivethings;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showOhmLaw(View view) {
        Intent intent = new Intent(this, TheOhmsLaw.class);
        startActivity(intent);
    }

    public void showVoltageDivider(View view) {
        startActivity(new Intent(this, VoltageDivider.class));
    }

    public void showCurrentDivider(View view) {
        startActivity(new Intent(this, CurrentDivider.class));
    }

    public void showResonant(View view) {
        startActivity(new Intent(this, ResonantCircuit.class));
    }

    public void showColorCodes(View view) {
        startActivity(new Intent(this, ColorCode.class));
    }
}
