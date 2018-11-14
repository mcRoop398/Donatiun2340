//package com.example.claireroop.donatiun_2340.Model;
//
//import java.io.Serializable;
//
//public class Account {
//
//    private String _email;
//    private String _name;
//    private String _password;
//    private Role _role;
//    private String _id;
//
//    private Account() {
//
//    }
//
//    public Account(String email, String password, String name, Role role) {
//        _email = email;
//        _password = password;
//        _name = name;
//        _role = role;
//        // _id = id;
//    }
//
//    //utilities
//    public boolean isAdmin() {
//        return _role == Role.ADMIN;
//    }
//
//    public boolean isUser() {
//        return _role == Role.USER;
//    }
//
//    public boolean passwordEquals(String p) {
//        return p.equals(_password);
//    }
//
//    public void makeAdmin() {
//        set_role(Role.ADMIN);
//    }
//
//    public void makeUser() {
//        set_role(Role.USER);
//    }
//
//    //getters:
//    public String get_password() {
//        return _password;
//    }
//
//    public Role get_role() {
//        return _role;
//    }
//
//    public String get_name() {
//        return _name;
//    }
//
//    public String get_email() {
//        return _email;
//    }
//
//    public String get_id() {
//        return _id;
//    }
//
//    //setters:
//    public void set_password(String p) {
//        _password = p;
//    }
//
//    public void set_role(Role r) {
//        _role = r;
//    }
//
//    public void set_name(String name) {
//        _name = name;
//    }
//
//    public void set_email(String e) {
//        _email = e;
//    }
//
//    public void set_id(String id) {
//        _id = id;
//    }
//
//}

package com.example.claireroop.donatiun_2340.Model;

import java.io.Serializable;

public class Account {

    private String _email;
    private String _name;
    private String _password;
    private Role _role;
    private String _id;
    private SimpleModel model = SimpleModel.INSTANCE;

    public Account() {

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

    public int registerUser(String name, String email, String password, Role role) {
        if (!isEmailValid(email)) {
            return 1;
        } else if (!isPasswordValid(password)) {
            return 2;
        } else if (name.matches("")) {
            return 3;
        } else if (Model.getListOfusers().createNewUser(email, password, name, role)) {
            _name = name;
            _password = password;
            _email = email;
            _role = role;
            return 0;
        } else {
            //Say user already created.
            return 4;
        }
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

}