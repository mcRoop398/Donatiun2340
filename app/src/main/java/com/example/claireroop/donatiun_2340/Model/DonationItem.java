package com.example.claireroop.donatiun_2340.Model;

import android.util.Log;

import java.util.ArrayList;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DonationItem {
    /*
    ITEM INFO
// THIS WILL NOT BE CHANGED BY THE USER. IT WILL BE AUTOMATICALLY UPDATED WITH THE ARRAYLIST
// index of ArrayList
Item ID: [_______]
Item name: // Can and should be changed - specific donation thing EX: Rollerblades
Category: String - Up to User
Color: String
Condition: String
Value: String - Dollars
DONATOR INFO
Donator's name: String
Donator's Phone #: String
*/
    SimpleModel model = SimpleModel.INSTANCE;

//    final DatabaseReference _dbRef = FirebaseDatabase.getInstance().getReference();
//    final DatabaseReference _locationRef = _dbRef.child("locations");
//    final DatabaseReference _donationRef = _dbRef.child("donations");
//    DatabaseReference _itemRef;
//    DatabaseReference _itemRef2;
//    DatabaseReference _itemRef3;
//    DatabaseReference _itemRef4;


    public DonationItem(String itemName, String cat, String ID, String col, String con,
                        String val, String donatName, String donatPhone,
                        ArrayList<DonationItem> list) {
        this.itemName = itemName;
        this.category = cat;
        this.ID = ID;
        this.color = col;
        this.condition = con;
        this.value = val;
        this.donatorName = donatName;
        this.donatorPhoneNumber = donatPhone;
        this.listContainedIn = list;
        this.isInList = false;
    }

    public DonationItem(String itemName, String cat, String ID, String col, String con,
                        String val, String donatName, String donatPhone) {
        this.itemName = itemName;
        this.category = cat;
        this.ID = ID;
        this.color = col;
        this.condition = con;
        this.value = val;
        this.donatorName = donatName;
        this.donatorPhoneNumber = donatPhone;
    }

    public String itemName;
    public String ID;
    public String category;
    public String color;
    public String condition;
    public String value;
    public String donatorName;
    public String donatorPhoneNumber;
    public ArrayList<DonationItem> listContainedIn;
    public boolean isInList;

//    public String getID() {
//        return ID;
//    }

    public void addedFlag() {
        this.isInList = true;
    }

    public boolean save(String itemName, String cat, String ID, String col, String con,
                        String val, String donatName, String donatPhone, int itemID) {
        if (itemName.length() > 1
                && category.length() > 1
                && ID.length() > 1
                && color.length() > 1
                && condition.length() > 1
                && value.length() > 1
                && donatName.length() > 1
                && donatPhone.length() > 1
                && itemID >= 0) {
            this.itemName = itemName;
            this.category = cat;
            this.ID = ID;
            this.color = col;
            this.condition = con;
            this.value = val;
            this.donatorName = donatName;
            this.donatorPhoneNumber = donatPhone;

            //pull in list then update it
//            DonationItem donation = new DonationItem(itemName, cat, ID, color, condition, value, donatName, donatPhone);
//            _itemRef = _donationRef.child(ID);
//            _itemRef.setValue(donation);
//
//            Log.e("onClick: ", ID);
//
//            DataItem location = model.getItems().get(itemID);
//            DataItem currLocation = location;
//
//            //adds donation name under locations category
//            _itemRef2 = _locationRef.child(currLocation.toString());
//            Log.e("currLocation: ", currLocation.toString());
//            _itemRef3 = _itemRef2.child("Donations");
//            _itemRef4 = _itemRef3.child(ID);
//            _itemRef4.setValue(donation);
            return true;
        } else {
            return false;
        }
    }
}