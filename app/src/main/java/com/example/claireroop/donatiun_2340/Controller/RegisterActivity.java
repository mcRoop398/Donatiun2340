package com.example.claireroop.donatiun_2340.Controller;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;

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

        /** Expected: if(Text fields are not empty)
         *               if(new user was not in the list of emails) then finish
         *               else{set email error - email already used}
         *
         */

        if(!(_name.getText().toString().matches("")) && !(_email.getText().toString().matches("")) && !(_password.getText().toString().matches(""))){
            if(_list.createNewUser(_email.getText().toString(), _password.getText().toString(), _name.getText().toString())){
                Intent i = new Intent(getApplicationContext(), ResolutionActivity.class);
                startActivity(i);
            }
            else{
                //Say user already created.
                _email.setError("Email already has an account linked.");
            }
        }
        else {
            alertDialog = new AlertDialog.Builder(this);
            alertDialog.setMessage("Please fill out required fields");
            alertDialog.show();
        }
    }

    public void onClickCancelButton(View v) {
        //Intent i = new Intent(getApplicationContext(), WelcomeActivity.class);
        //startActivity(i);
        finish();
    }

}
