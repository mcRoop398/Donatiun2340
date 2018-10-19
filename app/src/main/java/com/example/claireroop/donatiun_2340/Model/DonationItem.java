package com.example.claireroop.donatiun_2340.Model;

import java.util.ArrayList;

public class DonationItem {

    private String name;
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






    public DonationItem(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}