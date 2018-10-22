package com.example.claireroop.donatiun_2340.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

import com.example.claireroop.donatiun_2340.Model.DonationItem;
import com.example.claireroop.donatiun_2340.Model.SimpleModel;
import com.example.claireroop.donatiun_2340.R;

public class DonationItemInfoActivity extends AppCompatActivity {

    EditText name;
    TextView view1;
    TextView view2;
    TextView view3;
    TextView view4;
    EditText edit1;
    EditText edit2;
    EditText edit3;
    EditText edit4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        name = (EditText) findViewById(R.id.DonationItemNameText);
        view1 = (TextView) findViewById(R.id.view1);
        view2 = (TextView) findViewById(R.id.view2);
        view3 = (TextView) findViewById(R.id.view3);
        view4 = (TextView) findViewById(R.id.view4);
        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        edit3 = (EditText) findViewById(R.id.edit3);
        edit4 = (EditText) findViewById(R.id.edit4);

        final SimpleModel model = SimpleModel.INSTANCE;
        final int donationItemIndex = model.getCurrentDonationItemIndex();
        final int dataItemIndex = model.getCurrentDataItemIndex();
        final DonationItem item = model.getItems().
                get(dataItemIndex).getDonationItemsList().
                get(donationItemIndex);

        name.setText(item.name);
        edit1.setText(item.category);
        edit2.setText(item.color);
        edit3.setText(item.condition);
        edit4.setText(item.value);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.donation_item_info_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button save = (Button) findViewById(R.id.save_button);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item.name = name.getText().toString();
                item.category = edit1.getText().toString();
                item.color = edit2.getText().toString();
                item.condition = edit3.getText().toString();
                item.value = edit4.getText().toString();

                Intent i = new Intent(getApplicationContext(), DataItemDetailActivity.class);
                startActivity(i);
            }
        });

        Button del = (Button) findViewById(R.id.delete_button);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item.listContainedIn.remove(donationItemIndex);
                Intent i = new Intent(getApplicationContext(), DataItemDetailActivity.class);
                startActivity(i);
            }
        });
    }

}
