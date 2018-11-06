package com.example.claireroop.donatiun_2340.Controller;


import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.example.claireroop.donatiun_2340.Model.DataItem;
import com.example.claireroop.donatiun_2340.Model.DonationItem;
import com.example.claireroop.donatiun_2340.Model.SimpleModel;
import com.example.claireroop.donatiun_2340.R;

import java.util.ArrayList;


/**
 *
 * Class Use: Individual Location Screen **************************
 *
 * */


/**
 * A fragment representing a single DataItem detail screen.
 * This fragment is either contained in a {@link DataItemListActivity}
 * in two-pane mode (on tablets) or a {@link DataItemDetailActivity}
 * on handsets.
 */
public class DataItemDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DataItem mItem;

    private ArrayAdapter adapter;

    private Spinner donationSpinner;

    //private Button map;

    private View rootView;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public DataItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            int item_id = getArguments().getInt(ARG_ITEM_ID);
            Log.d("MYAPP", "Start details for: " + item_id);
            mItem = SimpleModel.INSTANCE.findItemById(item_id);

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.getName());
            }
        }

        //ID = findViewById(R.id.btViewMap);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.dataitem_detail, container, false);
        Log.d("MYAPP", "Getting ready to set data");
        // Show the dummy content as text in a TextView.

        if (mItem != null) {

            final String[] donationID = new String[mItem.getDonationItemsList().size()];
            for(int i = 0; i < donationID.length; i++){
                donationID[i] =  mItem.getDonationItemsList().get(i).ID;
            }
            donationSpinner = rootView.findViewById(R.id.Donations);
            adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, donationID);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            donationSpinner.setAdapter(adapter);

            final Button newDonation = rootView.findViewById(R.id.New_Donation);
            final Button editDonation = rootView.findViewById(R.id.Edit_Donation);

            newDonation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DonationItemInfoActivity.newDonation = true;
                    Intent i = new Intent(getContext(), DonationItemInfoActivity.class);
                    i.putExtra("dataItemIndex", mItem.getKey()-1); //Index of current Location
                    startActivity(i);
                    editDonation.setError(null);
                    // addNewDonation screen
                    // put it in array list and let it update spinner
                }
            });
            editDonation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!mItem.getDonationItemsList().isEmpty()){
                        DonationItemInfoActivity.newDonation = false;
                        Intent i = new Intent(getContext(), DonationItemInfoActivity.class);
                        i.putExtra("dataItemIndex", mItem.getKey()-1); //Index of current Location
                        i.putExtra("donationIndex", donationSpinner.getSelectedItemPosition()); //Index of current Donation
                        startActivity(i);
                    }
                    else{
                        editDonation.setError("No donations to edit");
                    }
                    // check selected spinner donation
                    // send it all to editDonation screen
                }
            });


//            /**
//             * This loop will put the array list in the spinner
//             *      Maybe put in "onClick" - for spinner
//             */

            Log.d("MYAPP", "Getting ready to set id");
            //((TextView) rootView.findViewById(R.id.id2)).setText("" + mItem.getId());
            ((TextView) rootView.findViewById(R.id.key)).setText("" + mItem.getKey());
            Log.d("MYAPP", "Getting ready to set name");
            ((TextView) rootView.findViewById(R.id.name)).setText(mItem.getName());
            ((TextView) rootView.findViewById(R.id.type)).setText("" + mItem.getType());
            ((TextView) rootView.findViewById(R.id.latitude)).setText("" + mItem.getLatitude());
            ((TextView) rootView.findViewById(R.id.longitude)).setText("" + mItem.getLongitude());
            ((TextView) rootView.findViewById(R.id.address)).setText("" + mItem.getAddress());
            ((TextView) rootView.findViewById(R.id.city)).setText("" + mItem.getCity());
            ((TextView) rootView.findViewById(R.id.state)).setText("" + mItem.getState());
            ((TextView) rootView.findViewById(R.id.zip)).setText("" + mItem.getZip());
            ((TextView) rootView.findViewById(R.id.phone)).setText("" + mItem.getPhone());
            ((TextView) rootView.findViewById(R.id.website)).setText("" + mItem.getWebsite());
        }



        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        final String[] donationID = new String[mItem.getDonationItemsList().size()];
        for(int i = 0; i < donationID.length; i++){
            donationID[i] =  mItem.getDonationItemsList().get(i).ID;
        }
        donationSpinner = rootView.findViewById(R.id.Donations);
        adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, donationID);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        donationSpinner.setAdapter(adapter);
        donationSpinner.setAdapter(adapter);

    }







//        Intent mapView = new Intent(getContext(), MapsActivity.class);
//        startActivity(mapView);



}

