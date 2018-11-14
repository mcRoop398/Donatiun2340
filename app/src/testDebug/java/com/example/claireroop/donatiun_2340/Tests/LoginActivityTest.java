package com.example.claireroop.donatiun_2340.Tests;

import android.util.Log;

import com.example.claireroop.donatiun_2340.Controller.LoginActivity;
import com.example.claireroop.donatiun_2340.Model.Account;
import com.example.claireroop.donatiun_2340.Model.AccountList;
import com.example.claireroop.donatiun_2340.Model.Role;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/*
Claire Roop's JUnit Test
 */

public class LoginActivityTest {

    LoginActivity activity;
    AccountList userList;

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
        userList.createNewUser("bob@bob.com", "hi", "Bob", Role.ADMIN);
        emailSh = "bob@bob.com";
        passwordSh = "hi";

        personIn = new Account("bob@bob.com", "hi@hi", "Bob", Role.ADMIN);
        userList.createNewUser("bob@bob.com", "hi@hi", "Bob", Role.ADMIN);
        emailIn = "bob@bob.com";
        passwordIn = "hi@hi";

        personG = new Account("bob@bob.com", "hello", "Bob", Role.ADMIN);
        userList.createNewUser("bob@bob.com", "hello", "Bob", Role.ADMIN);
        emailG = "bob@bob.com";
        passwordG = "hello";
    }

    @Test
    public void checkPasswordShort() {
        assertTrue("password too short", activity.checkPassword(emailSh, passwordSh));
    }

    @Test
    public void checkPasswordInvalid() {
         assertTrue("invalid password", activity.checkPassword(emailIn, passwordIn));
    }

    @Test
    public void checkPasswordValid() {
        assertFalse("Valid password", activity.checkPassword(emailSh, passwordSh));
    }
}