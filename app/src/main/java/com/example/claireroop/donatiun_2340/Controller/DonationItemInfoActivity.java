package com.example.claireroop.donatiun_2340.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

import com.example.claireroop.donatiun_2340.Model.DataItem;
import com.example.claireroop.donatiun_2340.Model.DonationItem;
import com.example.claireroop.donatiun_2340.Model.SimpleModel;
import com.example.claireroop.donatiun_2340.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DonationItemInfoActivity extends AppCompatActivity {

    EditText ID;
    EditText category;
    EditText color;
    EditText condition;
    EditText value;
    EditText itemName;
    EditText donor;
    EditText phoneNumber;

    static boolean newDonation = false;

//    final DatabaseReference _dbRef = FirebaseDatabase.getInstance().getReference();
//    final DatabaseReference _locationRef = _dbRef.child("locations");
//    final DatabaseReference _donationRef = _dbRef.child("donations");
//    DatabaseReference _itemRef;
//    DatabaseReference _itemRef2;
//    DatabaseReference _itemRef3;
//    DatabaseReference _itemRef4;
    final List<DonationItem> itemList = new ArrayList<>();
    List<String> realList = new ArrayList<>();
    DataItem currLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_screen);

        final SimpleModel model = SimpleModel.INSTANCE;
        final int dataItemIndex = getIntent().getIntExtra("dataItemIndex", 0);
        final ArrayList<DonationItem> donationItemList = model.getItems().get(dataItemIndex).getDonationItemsList();
        final int donationItemIndex = getIntent().getIntExtra("donationIndex", donationItemList.size() - 1);
        final DonationItem item;
        DataItem location = model.getItems().get(dataItemIndex);
        currLocation = location;

        //final DatabaseReference _dbRef = FirebaseDatabase.getInstance().getReference();
        //final DatabaseReference _donationRef = _dbRef.child("locations");
        //final List<Object> itemList = new ArrayList<>();
        //final DonationItem donation;


        /**
         * Creating new donation item - to end of the list
         */
        if (newDonation == true) {
            DonationItem newDonation = new DonationItem("", "", "",
                    "", "", "",
                    "", "",
                    model.getItems().get(dataItemIndex).getDonationItemsList());
            //add new donation to list
            donationItemList.add(donationItemList.size(), newDonation);
            //item is the newDonation
            item = newDonation;
        }
        /**
         * Editing current donation item
         * Based on previous screen the list can not be empty when trying to edit
         */
        else {
            //item = model.getItems().get(dataItemIndex).getDonationItemsList().get(donationItemIndex);
            item = model.itemView();
        }

        ID = findViewById(R.id.DonationID);
        category = findViewById(R.id.Category);
        color = findViewById(R.id.Color);
        condition = findViewById(R.id.Condition);
        value = findViewById(R.id.Value);
        itemName = findViewById(R.id.ItemName);
        donor = findViewById(R.id.Donor);
        phoneNumber = findViewById(R.id.Phone_Number);


        ID.setText(item.ID);
        category.setText(item.category);
        color.setText(item.color);
        condition.setText(item.condition);
        value.setText(item.value);
        itemName.setText(item.itemName);
        donor.setText(item.donatorName);
        phoneNumber.setText(item.donatorPhoneNumber);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button save = (Button) findViewById(R.id.save_button);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item.save(itemName.getText().toString(), category.getText().toString(),
                        ID.getText().toString(), color.getText().toString(),
                        condition.getText().toString(), value.getText().toString(),
                        donor.getText().toString(), phoneNumber.getText().toString(),
                        donationItemIndex);
                //pull in list then update it
                //DonationItem donation = new DonationItem(itemName.getText().toString(), category.getText().toString(), ID.getText().toString(), color.getText().toString(), condition.getText().toString(), value.getText().toString(), donor.getText().toString(), phoneNumber.getText().toString());
                //_itemRef = _donationRef.child(ID.getText().toString());
                //_itemRef.setValue(donation);
                //Log.e("onClick: ",ID.getText().toString());
                //adds donation name under locations category
                //_itemRef2 = _locationRef.child(currLocation.toString());
                //Log.e("currLocation: ", currLocation.toString());
                //_itemRef3 = _itemRef2.child("Donations");
                //_itemRef4 = _itemRef3.child(ID.getText().toString());
                //_itemRef4.setValue(donation);
                //itemList.add(donation);
                //DatabaseReference itemref = _donationRef.child("donations");
                //itemref.setValue(itemList);
                finish();
            }
        });


//        DonationItem donation = new DonationItem(itemName.getText().toString(), category.getText().toString(), ID.getText().toString(), color.getText().toString(), condition.getText().toString(), value.getText().toString(), donor.getText().toString(), phoneNumber.getText().toString());
//        itemList.add(donation);
//        DatabaseReference itemref = _donationRef.child("donations");
//        itemref.setValue(itemList);
//        finish();

        Button del = (Button) findViewById(R.id.delete_button);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                donationItemList.remove(item);
                finish();
            }
        });
    }
}