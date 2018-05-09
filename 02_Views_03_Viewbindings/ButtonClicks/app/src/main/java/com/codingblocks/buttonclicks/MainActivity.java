package com.codingblocks.buttonclicks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = "BTN";

    Button btn2;
    Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Second button clicked");
            }
        });

        btn3.setOnClickListener(this);
    }

    public void onButtonClicked (View v) {
        Log.d(TAG, "Button clicked");
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "3rd Button clicked");
    }
}
