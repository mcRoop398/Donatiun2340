package com.example.claireroop.donatiun_2340.Model;

public class Location implements Comparable<Location> {

    /**
     * class is comparable so we can use an alphabetized sorted set for storing the data.
     * Doesn't implement comparable because
     */
    private String _name;
    private String _type;
    private double _latitude;
    private double _longitude;
    private String _address;
    private Long _phoneNumber;

    public Location(String name, String type, double latitude, double longitude, String address, Long phoneNumber) {
        _name = name;
        _type = type;
        _latitude = latitude;
        _longitude = longitude;
        _address = address;
        _phoneNumber = phoneNumber;
    }

    public String getName() {
        return _name;
    }

    public String getType() {
        return _type;
    }

    public double getLatitude() {
        return _latitude;
    }

    public double getLongitude() {
        return _longitude;
    }

    public String getAddress() {
        return _address;
    }

    public Long getPhoneNumber() {
        return _phoneNumber;
    }

    // if value is zero then the location is considered a duplicate
    public int compareTo(Location l) {
        if (_name.compareTo(l.getName()) > 0) {
            return 1;
        } else if (_name.compareTo(l.getName()) < 0) {
            return -1;
        } else {
            if (_type.compareTo(l.getAddress()) > 0) {
                return 1;
            } else if (_type.compareTo(l.getAddress()) < 0) {
                return -1;
            } else {
                if (_address.compareTo(l.getAddress()) > 0) {
                    return 1;
                } else if (_address.compareTo(l.getAddress()) < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }
}
