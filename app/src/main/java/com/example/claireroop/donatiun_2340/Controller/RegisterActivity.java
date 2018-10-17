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

public class RegisterActivity extends AppCompatActivity {


    private EditText _name;
    private EditText _email;
    private EditText _password;
    private AccountList _list;
    private AlertDialog.Builder alertDialog;
    private Spinner _AccountTypeSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Initialize the AccountTypeSpinner
        _AccountTypeSpinner = findViewById(R.id.AccountTypeSpinner);

        //set up adapted for spinner
        ArrayAdapter<Role> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, Role.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        _AccountTypeSpinner.setAdapter(adapter);
    }

    public void onClickSubmitButton(View v) {
        //Intent i = new Intent(getApplicationContext(), WelcomeActivity.class);
        //startActivity(i);
        _name = findViewById(R.id.name);
        _email = findViewById(R.id.email);
        _password = findViewById(R.id.password);
        _list = Model.getListOfusers();


        /** Checks Email
         *  Checks Password
         *  Checks Name
         *  Create new user
         *      - if user email is brand new => make user and go to resolution screen
         *      - else if user email already exists (i.e. linked to an account) => Display Email Error
         */
        if(!isEmailValid(_email.getText().toString())){
            _email.setError("Email Invalid");
        }
        else if (!isPasswordValid(_password.getText().toString())) {
            _password.setError(getString(R.string.error_invalid_password));
        }
        else if(_name.getText().toString().matches("")) {
            _name.setError("Must Fill Out Name");
        }
        else if(_list.createNewUser(_email.getText().toString(), _password.getText().toString(), _name.getText().toString(), (Role) _AccountTypeSpinner.getSelectedItem())){
            Intent i = new Intent(getApplicationContext(), ResolutionActivity.class);
            startActivity(i);
        }
        else{
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