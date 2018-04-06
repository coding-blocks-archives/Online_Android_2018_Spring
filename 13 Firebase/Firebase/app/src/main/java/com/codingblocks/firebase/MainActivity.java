package com.codingblocks.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    ArrayList<String> notes;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btnDb);
        editText = findViewById(R.id.etNote);
        listView = findViewById(R.id.listView);
        notes = new ArrayList<>();
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                R.layout.item_row,
                R.id.tViewList,
                notes);

        listView.setAdapter(arrayAdapter);

        final DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String note = editText.getText().toString();
                //Upload the note to Firebase
//                Note n = new Note("Hello","World");

                dbRef.child("note").push().setValue(note);
//                dbRef.child("todo").push().setValue(note);
            }
        });

        dbRef.child("note").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                //Called when a new data node is inserted to the "note" node
//                Note data = dataSnapshot.getValue(Note.class);
                String data = dataSnapshot.getValue(String.class);
                notes.add(data);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                //An Existing data node is updated
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                //When a data at a subnode is removed
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                //When the position of a subNode changes
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //When the read operation failed
            }
        });

        dbRef.child("note").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Gets the entire database regardless of the operation
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
