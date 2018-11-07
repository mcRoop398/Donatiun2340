package com.example.claireroop.donatiun_2340.Model;

import java.util.ArrayList;

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
}