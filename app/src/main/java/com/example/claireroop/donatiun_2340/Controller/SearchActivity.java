package com.example.claireroop.donatiun_2340.Controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.claireroop.donatiun_2340.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SearchActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

//        DatabaseReference _dbRef = FirebaseDatabase.getInstance().getReference();
//        DatabaseReference _accountRef = _dbRef.child("accounts");
//        DatabaseReference _bobRef = _accountRef.child("bob");
//
//        HashMap<String, Object> update = new HashMap<>();
//        update.put("name", "YEEEEEEEE");
//        _bobRef.updateChildren(update);

    }

}
