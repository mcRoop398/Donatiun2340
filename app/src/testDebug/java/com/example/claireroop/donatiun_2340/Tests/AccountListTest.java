package com.example.claireroop.donatiun_2340.Tests;

import com.example.claireroop.donatiun_2340.Model.Account;
import com.example.claireroop.donatiun_2340.Model.AccountList;
import com.example.claireroop.donatiun_2340.Model.Role;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

/*
Claire Roop's JUnit Test
 */

public class AccountListTest {

    String emailG;
    String passwordG;

    String emailB;
    String passwordB;

    String emailNull;
    String passwordNull;

    AccountList list = new AccountList();

    Account person1;


    @Before
    public void setUp() throws Exception {
        emailG = "bob@gmail.com";
        passwordG = "hello";

        emailB = "yee@gmail.com";
        passwordB = "yeeeeee";

        emailNull = null;
        passwordNull = null;

        person1 = new Account("bob@gmail.com", "hello", "Bob", Role.ADMIN);
        list.addUser(person1);
    }

    @Test
    public void correctEmailPassword() {
        assertTrue("correct email and password", list.compareAccountToPassword(emailG, passwordG));
    }

    @Test
    public void incorrectEmailPassword() {
        assertFalse("incorrect email and password", list.compareAccountToPassword(emailB, passwordB));
    }

    @Test
    public void correctPassword() {
        assertFalse("incorrect email and correct password", list.compareAccountToPassword(emailB, passwordG));
    }

    @Test
    public void correctEmail() {
        assertFalse("correct email and incorrect password", list.compareAccountToPassword(emailG, passwordB));
    }
}