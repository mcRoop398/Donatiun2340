package com.example.claireroop.donatiun_2340.Tests;

import com.example.claireroop.donatiun_2340.Model.Account;
import com.example.claireroop.donatiun_2340.Model.Role;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/*
Darby Foster's JUnit test
 */
public class JUnitTestDarby {

    private Account account;
    private String nameGood;
    private String nameBad;
    private String nameNew;
    private String emailGood;
    private String emailBad;
    private String emailNew;
    private String passwordGood;
    private String passwordBad;
    private Role role;
    private Role role2;

    @Before
    public void setUp() {
        // make sure this user is not in the database already
        nameGood = "Darby";
        nameBad = "";
        nameNew = "new";
        emailGood = "darbyfoster@gatech.edu";
        emailBad = "email";
        emailNew = "new@gmail.com";
        passwordGood = "password";
        passwordBad = "x";
        role = Role.USER;
        role2 = Role.ADMIN;

        account = new Account();
    }

    /*
     * Account.registerUser() results:
     *  0 - create new user
     *  1 - invalid email
     *  2 - invalid password
     *  3 - invalid name
     *  4 - user already exists in database
     */

    @Test
    public void testEmail() {
        // passes if email is invalid
        assertEquals("email must be invalid", 1,
                account.registerUser(nameGood, emailBad, passwordGood, role));
    }

    @Test
    public void testPassword() {
        // passes if password is invalid
        assertEquals("password must be invalid", 2,
                account.registerUser(nameGood, emailGood, passwordBad, role));
    }

    @Test
    public void testName() {
        // passes if name is invalid
        assertEquals("name must be invalid", 3,
                account.registerUser(nameBad, emailGood, passwordGood, role));
    }

    @Test
    public void testNewUser() {
        // passes if new user can be registered
        assertEquals("user must be new and valid", 0,
                account.registerUser(nameNew, emailNew, passwordGood, role));
    }

    @Test
    public void testExistingUser() {
        // passes if user already exists in database
        assertEquals("user must already exist in database", 4,
                account.registerUser(nameGood, emailGood, passwordGood, role2));
    }
}