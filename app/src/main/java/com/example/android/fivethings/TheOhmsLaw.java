package com.example.android.fivethings;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

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
                    }
//                    Log.v("ohm","v = " + editV.getText().toString());
//                    Log.v("ohm","vID = " + editV.getId());
//                    Log.v("ohm","i = " + editI.getText().toString());
//                    Log.v("ohm","iID = " + editI.getId());
//                    Log.v("ohm","r = " + editR.getText().toString());
//                    Log.v("ohm","rID = " + editR.getId());
//                    Log.v("ohm","thisID = " + v.getId());

                    Double res = Double.parseDouble(editR.getText().toString());
                    switch (v.getId()) {
                        case R.id.editText:
                            if (prevId == R.id.editText2) {
                                if (res != 0) {
                                    editI.setText("" + Double.parseDouble(editV.getText().toString()) / res);
                                }
                            } else {
                                editR.setText("" + Double.parseDouble(editV.getText().toString()) / Double.parseDouble(editI.getText().toString()));
                            }
                            break;
                        case R.id.editText2:
                            if (prevId == R.id.editText) {
                                if (res != 0) {
                                    editI.setText("" + Double.parseDouble(editV.getText().toString()) / res);
                                }
                            } else {
                                editV.setText("" + Double.parseDouble(editI.getText().toString()) * res);
                            }
                            break;
                        case R.id.editText3:
                            if (prevId == R.id.editText) {
                                editR.setText("" + Double.parseDouble(editV.getText().toString()) / Double.parseDouble(editI.getText().toString()));
                            } else {
                                editV.setText("" + Double.parseDouble(editI.getText().toString()) * res);

                            }
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
