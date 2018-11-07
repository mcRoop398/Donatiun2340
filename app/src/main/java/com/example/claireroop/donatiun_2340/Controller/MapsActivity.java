package com.example.claireroop.donatiun_2340.Controller;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.claireroop.donatiun_2340.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker at Location01 and move the camera
        LatLng location01 = new LatLng(33.75416, -84.37742);
        mMap.addMarker(new MarkerOptions().position(location01).title("AFD Station 4").snippet("404-555-3456"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location01));

        // Add a marker at Location02 and move the camera
        LatLng location02 = new LatLng(33.73182, -84.43971);
        mMap.addMarker(new MarkerOptions().position(location02).title("Boys & Girls Club W.W. Woolfolk").snippet("404-555-1234"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location02));

        // Add a marker at Location03 and move the camera
        LatLng location03 = new LatLng(33.70866, -84.41853);
        mMap.addMarker(new MarkerOptions().position(location03).title("Pathway Upper Room Christian Ministries").snippet("404-555-5432"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location03));

        // Add a marker at Location04 and move the camera
        LatLng location04 = new LatLng(33.80129, -84.25537);
        mMap.addMarker(new MarkerOptions().position(location04).title("Pavilion of Hope, Inc.").snippet("404-555-8765"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location04));

        // Add a marker at Location05 and move the camera
        LatLng location05 = new LatLng(33.71747, -84.25210);
        mMap.addMarker(new MarkerOptions().position(location05).title("D&D Convenience Store").snippet("404-555-9876"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location01));

        // Add a marker at Location06 and move the camera
        LatLng location06 = new LatLng(33.96921, -84.36880);
        mMap.addMarker(new MarkerOptions().position(location06).title("Keep North Fulton Beautiful").snippet("770-555-7321"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location06));
    }
}
