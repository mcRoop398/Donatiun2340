package com.example.claireroop.donatiun_2340.Tests;

import com.example.claireroop.donatiun_2340.Model.DataItem;
import com.example.claireroop.donatiun_2340.Model.SimpleModel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/*
John Jajeh's JUnit Test
 */

public class SimpleModelTest {

    private SimpleModel sm;
    private DataItem di;

    @Before
    public void setUp() throws Exception {
        sm = SimpleModel.INSTANCE;
        di = new DataItem(6, "", 0, 0,
                "", "", "", 0, "", "", "");
        sm.addItem(di);
    }

    @Test
    public void findItemById() {
        assertEquals("The key is correct", di, sm.findItemById(6));
        assertEquals("The key is incorrect", null, sm.findItemById(0));
    }
}