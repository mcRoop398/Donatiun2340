package com.example.claireroop.donatiun_2340.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.claireroop.donatiun_2340.Model.DataItem;
import com.example.claireroop.donatiun_2340.Model.SimpleModel;
import com.example.claireroop.donatiun_2340.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class ResolutionActivity extends AppCompatActivity {

    public static String TAG = "MY_APP";
    private static boolean wasViewLocationClicked = false;

    DatabaseReference _dbRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference _accountRef = _dbRef.child("locations");
    DatabaseReference _personRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resolution);

    }

    public void onClickCancelButton(View v) {
        Intent i = new Intent(getApplicationContext(), WelcomeActivity.class);
        startActivity(i);

    }

//    public void onClickLocationsButton(View v) {
//        Intent i = new Intent(getApplicationContext(), LocationListActivity.class);
//        startActivity(i);
//
//    }

    public void onClickLocationsButton(View view) {
        Log.v(ResolutionActivity.TAG, "Pressed the load button");
        if (!wasViewLocationClicked) {
            wasViewLocationClicked = true;
            readSDFile();
        }
        Intent intent = new Intent(this, DataItemListActivity.class);
        startActivity(intent);
    }

    /**
     * Open the locationdata.csv file in the /res/raw directory
     * Line Entry format:
     *   [0] - Key
     *   [1] - Name **
     *   [2] - Latitude **
     *   [3] - Longitude **
     *   [4] - Street Address **
     *   [5] - City
     *   [6] - State
     *   [7] - Zip
     *   [8] - Type **
     *   [9] - Phone **
     *   [10] - Website
     *   **must be used/displayed
     */
    private void readSDFile() {
        SimpleModel model = SimpleModel.INSTANCE;

        try {
            //Open a stream on the raw file
            InputStream is = getResources().openRawResource(R.raw.locationdata);
            //From here we probably should call a model method and pass the InputStream
            //Wrap it in a BufferedReader so that we get the readLine() method
            BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

            String line;
            br.readLine(); //get rid of header line
            while ((line = br.readLine()) != null) {
                Log.d(ResolutionActivity.TAG, line);
                String[] tokens = line.split(",");
                int key = Integer.parseInt(tokens[0]);
                double latitude = Double.parseDouble(tokens[2]);
                double longitude = Double.parseDouble(tokens[3]);
                int zip = Integer.parseInt(tokens[7]);
                model.addItem(new DataItem(key, tokens[1], latitude, longitude, tokens[4], tokens[5],
                        tokens[6], zip, tokens[8], tokens[9], tokens[10]));

                HashMap<String, Object> update = new HashMap<>();
               DataItem newLocation = new DataItem(key,tokens[1], latitude, longitude, tokens[4], tokens[5], tokens[6], zip, tokens[8], tokens[9], tokens[10]);
                _personRef = _accountRef.child(newLocation.getName().substring(4 ,6));
                _personRef.setValue(newLocation);
                //_personRef = _accountRef.push();
//                update.put("firebaseid", _personRef.getKey());
//                update.put("name", tokens[1]);
//                update.put("key", key);
//                update.put("latitude",latitude);
//                update.put("longitude", longitude);
//                update.put("zip", zip);
//                _personRef.updateChildren(update);
            }
            br.close();
        } catch (IOException e) {
            Log.e(ResolutionActivity.TAG, "error reading assets", e);
        }

    }
}
