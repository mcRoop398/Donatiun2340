package com.example.claireroop.donatiun_2340.Tests;

import com.example.claireroop.donatiun_2340.Model.DataItem;
import com.example.claireroop.donatiun_2340.Model.DonationItem;
import com.example.claireroop.donatiun_2340.Model.SimpleModel;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/*
Tommy Landman's JUnit Test
 */

public class DonationSaveTest {

    DonationItem donation;
    DataItem location;


    @Before
    public void setUp() {
        donation = new DonationItem("name",
                "category", "ID", "col", "condition",
                "val", "cba","1234567890");
        location = new DataItem(0, "place",
                50, 40 , "abd street",
                "atlanta", "GA", 12345, "donation site",
                "1234567890", "d.com");
    }

    @Test
    public void testSaveMethod() {
        assertTrue(donation.save("abc","abc","abc","abc","abc","abc","abc","abc",1000));
        assertEquals(donation.itemName, "abc");
        assertEquals(donation.category, "abc");
        assertEquals(donation.ID, "abc");
        assertEquals(donation.color, "abc");
        assertEquals(donation.condition, "abc");
        assertEquals(donation.value, "abc");
        assertEquals(donation.donatorName, "abc");
        assertEquals(donation.donatorPhoneNumber, "abc");
    }


    @Test
    public void testSaveFails() {
        assertFalse(donation.save("","","","","","","","",1000));
        assertTrue(donation.save("abc","abc","abc","abc","abc","abc","abc","abc",1000));
        assertFalse(donation.save("","abc","abc","abc","abc","abc","abc","abc",1000));
        assertFalse(donation.save("abc","","abc","abc","abc","abc","abc","abc",1000));
        assertFalse(donation.save("abc","abc","","abc","abc","abc","abc","abc",1000));
        assertFalse(donation.save("abc","abc","abc","","abc","abc","abc","abc",1000));
        assertFalse(donation.save("abc","abc","abc","abc","","abc","abc","abc",1000));
        assertFalse(donation.save("abc","abc","abc","abc","abc","","abc","abc",1000));
        assertFalse(donation.save("abc","abc","abc","abc","abc","abc","","abc",1000));
        assertFalse(donation.save("abc","abc","abc","abc","abc","abc","abc","",1000));
        assertFalse(donation.save("abc","abc","abc","abc","abc","abc","abc","abc",-2));
    }

}