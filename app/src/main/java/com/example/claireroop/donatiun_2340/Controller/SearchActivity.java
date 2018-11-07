package com.example.claireroop.donatiun_2340.Controller;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.example.claireroop.donatiun_2340.Model.DonationItem;
import com.example.claireroop.donatiun_2340.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

//    public static void searchByCategory(DonationItem donation, String location) {
//        DatabaseReference _dbRef = FirebaseDatabase.getInstance().getReference();
//        DatabaseReference _accountRef = _dbRef.child("donations");
//        final List<String> itemList = new ArrayList<>();
//
//        _accountRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                DatabaseReference _donationRef;
//                for (DataSnapshot x : dataSnapshot.getChildren()) {
//                    if (dataSnapshot.child("category").getValue().equals("shoes")) {
//                        itemList.add(dataSnapshot.child("category").getValue().toString());
//                    }
//                }
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }
//
//    public static void searchByName (DonationItem donation, String location) {
//        DatabaseReference _dbRef = FirebaseDatabase.getInstance().getReference();
//        DatabaseReference _accountRef = _dbRef.child("donations");
//        DatabaseReference _donationRef = _accountRef.child(donation.getName());
//        final List<String> itemList = new ArrayList<>();
//
//        _donationRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (DataSnapshot x : dataSnapshot.getChildren()) {
//                    DataSnapshot yee = dataSnapshot.child("name");
//                    if (dataSnapshot.child("category").getValue().equals("shoe")) {
//                        itemList.add(dataSnapshot.child("category").getValue().toString());
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }

}
