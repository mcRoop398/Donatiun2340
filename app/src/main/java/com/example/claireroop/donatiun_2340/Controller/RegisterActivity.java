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
    private EditText _id;
    private AccountList _list;
    private AlertDialog.Builder alertDialog;
    private Spinner _AccountTypeSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Initialize the AccountTypeSpinner
        _AccountTypeSpinner = (Spinner) findViewById(R.id.AccountTypeSpinner);

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




        /** Expected: if(Text fields are not empty)
         *               if(new user was not in the list of emails) then finish
         *               else{set email error - email already used}
         *
         */
        if(!(_name.getText().toString().matches("")) && !(_email.getText().toString().matches("")) && !(_password.getText().toString().matches(""))){
            if(_list.createNewUser(_email.getText().toString(), _password.getText().toString(), _name.getText().toString(), (Role) _AccountTypeSpinner.getSelectedItem(), _id.getText().toString())){
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
