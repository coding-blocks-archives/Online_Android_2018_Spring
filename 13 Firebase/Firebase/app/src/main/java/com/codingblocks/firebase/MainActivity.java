package com.codingblocks.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.crashlytics.android.Crashlytics;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 1000;
    Button button;
    EditText editText;
    ArrayList<String> notes;
    ListView listView;
    FirebaseUser firebaseUser;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btnDb);
        editText = findViewById(R.id.etNote);
        listView = findViewById(R.id.listView);
        notes = new ArrayList<>();
        Crashlytics.getInstance().crash();
        arrayAdapter = new ArrayAdapter<>(this,
                R.layout.item_row,
                R.id.tViewList,
                notes);
        listView.setAdapter(arrayAdapter);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if (firebaseUser != null) {
            //Logged in
            addListeners();
        } else {
            //Logged out
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setIsSmartLockEnabled(false)  //disable google smart lock
                            .setAvailableProviders(Arrays.asList(
                                    new AuthUI.IdpConfig.EmailBuilder().build(),
                                    new AuthUI.IdpConfig.PhoneBuilder().build(),
                                    new AuthUI.IdpConfig.GoogleBuilder().build()))
                            .build(),
                    RC_SIGN_IN);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // RC_SIGN_IN is the request code you passed into startActivityForResult(...) when starting the sign in flow.
        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            // Successfully signed in
            if (resultCode == RESULT_OK) {
                firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                addListeners();
                Log.e("TAG", "onActivityResult: " + firebaseUser.getDisplayName());
                Log.e("TAG", "onActivityResult: " + firebaseUser.getUid());
            } else {
                // Sign in failed
                if (response == null) {
                    // User pressed back button
                    return;
                }

                if (response.getError().getErrorCode() == ErrorCodes.NO_NETWORK) {
                    return;
                }
            }
        }
    }

    public void addListeners(){
        final DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String note = editText.getText().toString();
                //Upload the note to Firebase
                dbRef.child("note").child(firebaseUser.getUid()).push().setValue(note);
            }
        });

        dbRef.child("note").child(firebaseUser.getUid()).addChildEventListener(new ChildEventListener() {
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
    }

}
