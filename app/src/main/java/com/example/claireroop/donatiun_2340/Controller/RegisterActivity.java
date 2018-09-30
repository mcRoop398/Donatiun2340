package com.example.claireroop.donatiun_2340.Controller;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
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
         *               if(finish - if new user was created/not already in the list of emails)
         *               else{set email error - email already used}
         *
         */

        if(!_name.getText().equals("") && !_email.getText().equals("") && !_password.getText().equals("")){
            if(_list.createNewUser(_email.getText().toString(), _password.getText().toString(), _name.getText().toString())){
                finish();
            }
            else{
                //Say user already created.
                _email.setError("Email already has an account linked.");
            }
        }
        else{
            //This doesn't work just yet.
            alertDialog = new AlertDialog.Builder(this);
            alertDialog.setMessage("Please fill out required fields");
            alertDialog.show();


            //Please fill out fields
//            FrameLayout f1 = v.findViewById(android.R.id.custom);
//            f1.addView(v, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        }
    }

    public void onClickCancelButton(View v) {
        //Intent i = new Intent(getApplicationContext(), WelcomeActivity.class);
        //startActivity(i);
        finish();
    }

}
