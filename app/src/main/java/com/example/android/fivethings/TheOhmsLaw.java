package com.example.android.fivethings;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TheOhmsLaw extends AppCompatActivity {
    int prevId;
    EditText editV, editR, editI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        requestWindowFeature(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_ohms_law);

        editV = (EditText) findViewById(R.id.editText);
        editR = (EditText) findViewById(R.id.editText2);
        editI = (EditText) findViewById(R.id.editText3);

        View.OnFocusChangeListener listener;
        listener = new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (((EditText) v).length() == 0) {
                        ((EditText) v).setText("0");
                    } else {
                        try {
                            Double.parseDouble(((EditText) v).getText().toString());
                        } catch (Exception e) {
                            Toast.makeText(TheOhmsLaw.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

//                    Log.v("ohm","v = " + editV.getText().toString());
//                    Log.v("ohm","vID = " + editV.getId());
//                    Log.v("ohm","i = " + editI.getText().toString());
//                    Log.v("ohm","iID = " + editI.getId());
//                    Log.v("ohm","r = " + editR.getText().toString());
//                    Log.v("ohm","rID = " + editR.getId());
//                    Log.v("ohm","thisID = " + v.getId());

                    Double res = Double.parseDouble(editR.getText().toString());
                    try {
                        switch (v.getId()) {
                            case R.id.editText:
                                if (prevId == R.id.editText2) {
                                    Double current = Double.parseDouble(editV.getText().toString()) / res;
                                    editI.setText("" + current);
                                    if (current.isInfinite() || current.isNaN()) {
                                        throw new ArithmeticException();
                                    }
                                } else {
                                    res = Double.parseDouble(editV.getText().toString()) / Double.parseDouble(editI.getText().toString());
                                    editR.setText("" + res);
                                    if (res.isInfinite() || res.isNaN()) {
                                        throw new ArithmeticException();
                                    }
                                }
                                break;
                            case R.id.editText2:
                                if (prevId == R.id.editText) {
                                    Double current = Double.parseDouble(editV.getText().toString()) / res;
                                    editI.setText("" + current);
                                    if (current.isInfinite() || current.isNaN()) {
                                        throw new ArithmeticException();
                                    }
                                } else {
                                    editV.setText("" + Double.parseDouble(editI.getText().toString()) * res);
                                }
                                break;
                            case R.id.editText3:
                                if (prevId == R.id.editText) {
                                    res = Double.parseDouble(editV.getText().toString()) / Double.parseDouble(editI.getText().toString());
                                    editR.setText("" + res);
                                    if (res.isInfinite() || res.isNaN()) {
                                        throw new ArithmeticException();
                                    }
                                } else {
                                    editV.setText("" + Double.parseDouble(editI.getText().toString()) * res);

                                }
                        }
                    } catch (ArithmeticException e) {
                        Toast.makeText(TheOhmsLaw.this, R.string.divByZero, Toast.LENGTH_SHORT).show();
                    }
                    prevId = v.getId();
                }
            }
        };

        editV.setOnFocusChangeListener(listener);
        editR.setOnFocusChangeListener(listener);
        editI.setOnFocusChangeListener(listener);

    }

}
