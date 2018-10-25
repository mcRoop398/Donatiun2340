package com.example.claireroop.donatiun_2340.Model;

import java.util.List;
import java.util.NoSuchElementException;

@SuppressWarnings("unused")
public interface DataAccessObject {

    Account getCurrentAccount();

    void setCurrentAccount(Account account);


    Account getAccountById(String id);

    void addAccount(Account account);
}
