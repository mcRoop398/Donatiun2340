//package com.example.claireroop.donatiun_2340.Controller;
//
//import android.app.AlertDialog;
//import android.app.Dialog;
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.Debug;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.app.AppCompatDialog;
//import android.util.Log;
//import android.text.TextUtils;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.EditText;
//import android.widget.FrameLayout;
//import android.widget.Spinner;
//import android.widget.ArrayAdapter;
//
//import com.example.claireroop.donatiun_2340.Model.AccountList;
//import com.example.claireroop.donatiun_2340.Model.Role;
//import com.example.claireroop.donatiun_2340.Model.Model;
//import com.example.claireroop.donatiun_2340.R;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.example.claireroop.donatiun_2340.Model.Account;
//
//import java.util.HashMap;
//
//public class RegisterActivity extends AppCompatActivity {
//
//
//    private EditText _name;
//    private EditText _email;
//    private EditText _password;
//    private Role _role;
//    private AccountList _list;
//    private AlertDialog.Builder alertDialog;
//    private Spinner _AccountTypeSpinner;
//
//    DatabaseReference _dbRef = FirebaseDatabase.getInstance().getReference();
//    DatabaseReference _accountRef = _dbRef.child("accounts");
//    DatabaseReference _personRef;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_register);
//
//        //Initialize the AccountTypeSpinner
//        _AccountTypeSpinner = findViewById(R.id.AccountTypeSpinner);
//
//        //set up adapted for spinner
//        ArrayAdapter<Role> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Role.values());
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        _AccountTypeSpinner.setAdapter(adapter);
//    }
//
//    public void onClickSubmitButton(View v) {
//        //Intent i = new Intent(getApplicationContext(), WelcomeActivity.class);
//        //startActivity(i);
//        _name = findViewById(R.id.name);
//        _email = findViewById(R.id.email);
//        _password = findViewById(R.id.password);
//        _list = Model.getListOfusers();
//        _role = (Role) _AccountTypeSpinner.getSelectedItem();
//
//
//        /** Checks Email
//         *  Checks Password
//         *  Checks Name
//         *  Create new user
//         *      - if user email is brand new => make user and go to resolution screen
//         *      - else if user email already exists (i.e. linked to an account) => Display Email Error
//         */
//        if (!isEmailValid(_email.getText().toString())) {
//            _email.setError("Email Invalid");
//        } else if (!isPasswordValid(_password.getText().toString())) {
//            _password.setError(getString(R.string.error_invalid_password));
//        } else if (_name.getText().toString().matches("")) {
//            _name.setError("Must Fill Out Name");
//        } else if (_list.createNewUser(_email.getText().toString(), _password.getText().toString(), _name.getText().toString(), (Role) _AccountTypeSpinner.getSelectedItem())) {
//            HashMap<String, Object> update = new HashMap<>();
//
//            Account newPerson = new Account(_email.getText().toString(), _password.getText().toString(), _name.getText().toString(), _role);
//            _personRef = _accountRef.child(newPerson.get_email().substring(0, newPerson.get_email().indexOf("@")));
//            _personRef.setValue(newPerson);
////            update.put("name", _name.getText().toString());
////            update.put("email", _email.getText().toString());
////            update.put("password", _password.getText().toString());
////            update.put("role", _AccountTypeSpinner.getSelectedItem());
//            //_personRef.updateChildren(update);
//            Intent i = new Intent(getApplicationContext(), ResolutionActivity.class);
//            startActivity(i);
//        } else {
//            //Say user already created.
//            _email.setError("Email already has an account linked.");
//        }
//    }
//
//    public void onClickCancelButton(View v) {
//        //Intent i = new Intent(getApplicationContext(), WelcomeActivity.class);
//        //startActivity(i);
//        finish();
//    }
//
//    private boolean isEmailValid(String email) {
//        //TODO: Replace this with your own logic
//        return email.contains("@");
//    }
//
//    private boolean isPasswordValid(String password) {
//        //TODO: Replace this with your own logic
//        return password.length() > 4;
//    }
//
//}

package com.example.claireroop.donatiun_2340.Controller;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDialog;
import android.util.Log;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

import com.example.claireroop.donatiun_2340.Model.AccountList;
import com.example.claireroop.donatiun_2340.Model.Role;
import com.example.claireroop.donatiun_2340.Model.Model;
import com.example.claireroop.donatiun_2340.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.example.claireroop.donatiun_2340.Model.Account;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {


    private EditText _name;
    private EditText _email;
    private EditText _password;
    private Role _role;
    private AccountList _list;
    private AlertDialog.Builder alertDialog;
    private Spinner _AccountTypeSpinner;

//    DatabaseReference _dbRef = FirebaseDatabase.getInstance().getReference();
//    DatabaseReference _accountRef = _dbRef.child("accounts");
//    DatabaseReference _personRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Initialize the AccountTypeSpinner
        _AccountTypeSpinner = findViewById(R.id.AccountTypeSpinner);

        //set up adapted for spinner
        ArrayAdapter<Role> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Role.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        _AccountTypeSpinner.setAdapter(adapter);
    }

    public void onClickSubmitButton(View v) {
        //Intent i = new Intent(getApplicationContext(), WelcomeActivity.class);
        //startActivity(i);
        Account acc = new Account();
        _name = findViewById(R.id.name);
        _email = findViewById(R.id.email);
        _password = findViewById(R.id.password);
        _list = Model.getListOfusers();
        _role = (Role) _AccountTypeSpinner.getSelectedItem();
        int registerResult = acc.registerUser(_name.getText().toString(),_email.getText().toString(),_password.getText().toString(),_role);

        /** Checks Email
         *  Checks Password
         *  Checks Name
         *  Create new user
         *      - if user email is brand new => make user and go to resolution screen
         *      - else if user email already exists (i.e. linked to an account) => Display Email Error
         */
        if (registerResult == 1) {
            _email.setError("Email Invalid");
        } else if (registerResult == 2) {
            _password.setError(getString(R.string.error_invalid_password));
        } else if (registerResult == 3) {
            _name.setError("Must Fill Out Name");
        } else if (registerResult == 0) {
            HashMap<String, Object> update = new HashMap<>();
//            _personRef = _accountRef.child(acc.get_email().substring(0, acc.get_email().indexOf("@")));
//            _personRef.setValue(acc);
//            update.put("name", _name.getText().toString());
//            update.put("email", _email.getText().toString());
//            update.put("password", _password.getText().toString());
//            update.put("role", _AccountTypeSpinner.getSelectedItem());
            //_personRef.updateChildren(update);
            Intent i = new Intent(getApplicationContext(), ResolutionActivity.class);
            startActivity(i);
        } else {
            //Say user already created.
            _email.setError("Email already has an account linked.");
        }
    }

    public void onClickCancelButton(View v) {
        //Intent i = new Intent(getApplicationContext(), WelcomeActivity.class);
        //startActivity(i);
        finish();
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

}