package com.example.claireroop.donatiun_2340.Tests;

import android.util.Log;

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

    LoginActivity activity;

    Account personSh;
    String emailSh;
    String passwordSh;

    Account personIn;
    String emailIn;
    String passwordIn;

    Account personG;
    String emailG;
    String passwordG;

    boolean test;

    @Before
    public void setUp() throws Exception {
        personSh = new Account("bob@bob.com", "hi", "Bob", Role.ADMIN);
        emailSh = "bob@bob.com";
        passwordSh = "hi";

        personIn = new Account("bob@bob.com", "hi", "Bob", Role.ADMIN);
        emailIn = "bob@bob.com";
        passwordIn = "hi@hi";

    }

    @Test
    public void checkPasswordTest() {
        //assertEquals("Password too short", true, checkPassword(email, password));
        test = activity.checkPassword(emailSh, passwordSh);
        assertTrue("password too short", activity.checkPassword(emailSh, passwordSh));
        assertTrue("invalid password", activity.checkPassword(emailIn, passwordIn));
        //assertTrue("password too short", activity.checkPassword(email, password));
    }
}