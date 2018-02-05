package com.codingblocks.liststrarr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] names = new String[] {
            "Arnav",
            "Prateek",
            "Deepak",
            "Garima",
            "Rishab",
            "Harshit",
            "Aayush",
            "Rajesh",
            "Harpreet",
            "Nipun",
            "Anuj",
            "Rishabh",
            "Bhavya",
            "Apoorva"
    };
    ListView lvNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvNames = findViewById(R.id.lvNames);
        ArrayAdapter<String> namesAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                names

        );
        lvNames.setAdapter(namesAdapter);
    }
}
