package com.example.claireroop.donatiun_2340.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@SuppressWarnings("ALL")
public class DummyDAO implements DataAccessObject {
    protected List<Account> accounts;
    protected Account currentAccount;

    private static final double METERS_IN_DEGREE = 111000.0;

    @Override
    public Account getCurrentAccount() {
        return currentAccount;
    }

    @Override
    public void setCurrentAccount(Account account) {
        currentAccount = account;
    }

    public DummyDAO() {
        accounts = new ArrayList<>();
        populateDummyData();
    }

    private void populateDummyData() {
        accounts.add(new Account("Test User", "user", "pass", Role.ADMIN, "1"));
    }

    @Override
    public Account getAccountById(String id) {
        for (Account account : accounts) {
            if (account.get_id().equals(id)) {
                return account;
            }
        }
        throw new NoSuchElementException("Could not find specified user");
    }

    @Override
    public void addAccount(Account account) {
        accounts.add(account);
    }

}
