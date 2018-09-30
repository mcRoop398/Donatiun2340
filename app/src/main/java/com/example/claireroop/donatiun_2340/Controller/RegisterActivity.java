package com.example.claireroop.donatiun_2340.Controller;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.example.claireroop.donatiun_2340.Model.AccountList;
import com.example.claireroop.donatiun_2340.Model.Model;
import com.example.claireroop.donatiun_2340.R;

public class RegisterActivity extends AppCompatActivity {


    private EditText _name;
    private EditText _email;
    private EditText _password;
    private AccountList _list;
    private AlertDialog.Builder alertDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void onClickSubmitButton(View v) {
        //Intent i = new Intent(getApplicationContext(), WelcomeActivity.class);
        //startActivity(i);
        _name = findViewById(R.id.name);
        _email = findViewById(R.id.email);
        _password = findViewById(R.id.password);
        _list = Model.getListOfusers();


        if (!TextUtils.isEmpty(_password.getText().toString()) && !isPasswordValid(_password.getText().toString())) {
            _password.setError(getString(R.string.error_invalid_password));
        } else if(!(_name.getText().toString().matches("")) && !(_email.getText().toString().matches("")) && !(_password.getText().toString().matches(""))){
            if(_list.createNewUser(_email.getText().toString(), _password.getText().toString(), _name.getText().toString())){
                Intent i = new Intent(getApplicationContext(), ResolutionActivity.class);
                startActivity(i);
            } else{
                _email.setError("Email already has an account linked.");
            }
        } else {
            alertDialog = new AlertDialog.Builder(this);
            alertDialog.setMessage("Please fill out required fields");
            alertDialog.show();
        }


        if(!isEmailValid(_email.getText().toString())){
            _email.setError("Email Invalid");
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