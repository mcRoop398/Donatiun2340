package com.example.claireroop.donatiun_2340.Tests;

import com.example.claireroop.donatiun_2340.Controller.LoginActivity;
import com.example.claireroop.donatiun_2340.Model.Account;
import com.example.claireroop.donatiun_2340.Model.Role;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/*
Claire Roop's JUnit Test
 */

public class LoginActivityTest {

    Account person;
    LoginActivity activity;

    @Before
    public void setUp() throws Exception {
        //activity = LoginActivity.INSTANCE;
        person = new Account("bob@bob.com", "hello", "Bob", Role.ADMIN);
    }

    @Test
    public void retrievePeople() {

    }
}