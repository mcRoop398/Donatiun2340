package com.example.claireroop.donatiun_2340.Controller;

/**
 * Created by robertwaters on 9/18/17.
 * Edited by Darby Foster on 10/12/18.
 */


public class DataItem {
    public int key;
    public String name;
    public double latitude;
    public double longitude;
    public String address;
    public String city;
    public String state;
    public double zip;
    public String type;
    public String phone;
    public String website;

    public DataItem(int key, String name, double latitude, double longitude,
                    String address, String city, String state, double zip, String type,
                    String phone, String website) {
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

    public int getKey() { return key; }
    public String getName() { return name; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public double getZip() { return zip; }
    public String getType() { return type; }
    public String getPhone() { return phone; }
    public String getWebsite() { return website; }
}

