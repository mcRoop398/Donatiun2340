package com.example.claireroop.donatiun_2340.Model;

import java.io.Serializable;

public class Account {

    private String _email;
    private String _name;
    private String _password;
    private Role _role;
    private String _id;

    private Account() {

    }

    public Account(String email, String password, String name, Role role) {
        _email = email;
        _password = password;
        _name = name;
        _role = role;
        // _id = id;
    }

    //utilities
    public boolean isAdmin() {
        return _role == Role.ADMIN;
    }

    public boolean isUser() {
        return _role == Role.USER;
    }

    public boolean passwordEquals(String p) {
        return p.equals(_password);
    }

    public void makeAdmin() {
        set_role(Role.ADMIN);
    }

    public void makeUser() {
        set_role(Role.USER);
    }

    //getters:
    public String get_password() {
        return _password;
    }

    public Role get_role() {
        return _role;
    }

    public String get_name() {
        return _name;
    }

    public String get_email() {
        return _email;
    }

    public String get_id() {
        return _id;
    }

    //setters:
    public void set_password(String p) {
        _password = p;
    }

    public void set_role(Role r) {
        _role = r;
    }

    public void set_name(String name) {
        _name = name;
    }

    public void set_email(String e) {
        _email = e;
    }

    public void set_id(String id) {
        _id = id;
    }

}
