package com.example.android.fivethings;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.NumberFormat;

public class VoltageDivider extends AppCompatActivity {

    int prevId;
    EditText editVin, editVout, editR1, editR2;
    double inV, outV, res1, res2;
    NumberFormat nf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voltage_divider);

        editVin = (EditText) findViewById(R.id.editTextVin);
        editVout = (EditText) findViewById(R.id.editTextVout);
        editR1 = (EditText) findViewById(R.id.editTextR1);
        editR2 = (EditText) findViewById(R.id.editTextR2);
        nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(6);

        editVin.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    inV = validateInput(((EditText) v));
                    calculateVout();
                }
            }
        });

        editR1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    res1 = validateInput(((EditText) v));
                    calculateVout();
                }
            }
        });

        editR2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    res2 = validateInput(((EditText) v));
                    calculateVout();
                }
            }
        });

    }

    protected double validateInput(EditText et) {
        prevId = et.getId();
        if (et.length() == 0) {
            et.setText("0");
        } else {
            try {
                return Double.parseDouble(et.getText().toString());
            } catch (Exception e) {
                Toast.makeText(VoltageDivider.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        return 0;
    }

    protected void calculateVout() {
        try {
            outV = inV * res2 / (res1 + res2);
            editVout.setText(nf.format(outV));
        } catch (ArithmeticException e) {
            Toast.makeText(VoltageDivider.this, R.string.divByZero, Toast.LENGTH_SHORT).show();
        }
    }
}
