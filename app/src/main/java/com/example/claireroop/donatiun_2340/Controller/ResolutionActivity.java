package com.example.claireroop.donatiun_2340.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.claireroop.donatiun_2340.R;

public class ResolutionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resolution);

    }

    public void onClickCancelButton(View v) {
        Intent i = new Intent(getApplicationContext(), WelcomeActivity.class);
        startActivity(i);

    }

    public void onClickLocationsButton(View v) {
        Intent i = new Intent(getApplicationContext(), LocationListActivity.class);
        startActivity(i);

    }

}
