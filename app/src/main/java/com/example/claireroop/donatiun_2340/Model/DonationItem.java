package com.example.claireroop.donatiun_2340.Model;

import android.media.Image;

public class DonationItem implements Comparable<DonationItem>{
    private String _name;
    private int _cardinality;
    private String _comment;
    private Image _image;

    public DonationItem(String name, int card, String comm, Image im) {
        _name = name;
        _cardinality = card;
        _comment = comm;
        _image = im;
    }

    public String getName() { return _name; }
    public int getCardinality() { return _cardinality; }
    public String getComment() { return _comment; }
    public Image getImage() { return _image; }

    public int compareTo(DonationItem d) {
        if (_name.compareTo(d.getName()) > 0) {
            return 1;
        } else if (_name.compareTo(d.getName()) < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
