package com.example.claireroop.donatiun_2340.Controller;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.claireroop.donatiun_2340.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

/**
 * This activity is what first greets users when they enter the app.
 */
public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        DatabaseReference _dbRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference _accountRef = _dbRef.child("accounts");
        DatabaseReference _bobRef = _accountRef.child("bob");

        HashMap<String, Object> update = new HashMap<>();
        update.put("name", "YEEEEEEEE");
        _bobRef.updateChildren(update);

    }


    /**
     * onClick handler to transition to login screen.
     *
     * @param v Login button
     */
    @SuppressWarnings("UnusedParameters")
    public void onClickLoginButton(View v) {
        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(i);

    }

    public void onClickRegisterButton(View v) {
        Intent intent02 = new Intent(getApplicationContext(), RegisterActivity.class);
        //intent02.putExtra("userEmail", userEmail);
        startActivity(intent02);

    }
}
