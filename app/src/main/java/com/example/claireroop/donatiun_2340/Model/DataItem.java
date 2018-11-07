package com.example.claireroop.donatiun_2340.Model;

import android.app.Activity;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robertwaters on 9/18/17.
 * Edited by Darby Foster on 10/12/18.
 * <p>
 * DataItem: each individual location
 */


public class DataItem {

    private ArrayList donationItemsList;
    private int key;
    private String name;
    private double latitude;
    private double longitude;
    private String address;
    private String city;
    private String state;
    private double zip;
    private String type;
    private String phone;
    private String website;

    public DataItem(int key, String name, double latitude, double longitude,
                    String address, String city, String state, double zip, String type,
                    String phone, String website) {
        this.donationItemsList = new ArrayList<DonationItem>();
        this.key = key;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.type = type;
        this.phone = phone;
        this.website = website;
    }

    public String toString() {
        return name + " - " + key;
    }


    /**
     * GETTERS
     */

    public int getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public double getZip() {
        return zip;
    }

    public String getType() {
        return type;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public ArrayList<DonationItem> getDonationItemsList() {
        return donationItemsList;
    }


    /**
     * SETTERS
     */

    public void setDonationItemsList(ArrayList<DonationItem> donationItemsList) {
        this.donationItemsList = donationItemsList;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(double zip) {
        this.zip = zip;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}