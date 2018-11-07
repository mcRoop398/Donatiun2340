package com.example.claireroop.donatiun_2340.Model;

//package edu.gatech.cs2340.csvfiledemo;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

//import edu.gatech.cs2340.csvfiledemo.dummy.DummyContent;

/**
 * Created by robertwaters on 9/18/17.
 */

public class SimpleModel {
    public static final SimpleModel INSTANCE = new SimpleModel();

    private List<DataItem> items;

    private SimpleModel() {
        items = new ArrayList<>();
    }

    public void addItem(DataItem item) {
        items.add(item);
    }

    public List<DataItem> getItems() {
        return items;
    }

    public DataItem findItemById(int key) {
        for (DataItem d : items) {
            //if (d.getId() == id) return d;
            if (d.getKey() == key) {
                return d;
            }
        }
        Log.d("MYAPP", "Warning - Failed to find key: " + key);
        return null;
    }

    private int _currentDonationItemIndex;

    public int getCurrentDonationItemIndex() {
        return _currentDonationItemIndex;
    }

    private int _currentDataItemIndex;

    public int getCurrentDataItemIndex() {
        return _currentDataItemIndex;
    }

    public void setCurrentDonationItemIndex(int i) {
        _currentDonationItemIndex = i;
    }

    public void setCurrentDataItemIndex(int i) {
        _currentDataItemIndex = i;
    }

    public DonationItem itemView() {
        return items.get(_currentDataItemIndex).getItem(_currentDonationItemIndex);
    }

}