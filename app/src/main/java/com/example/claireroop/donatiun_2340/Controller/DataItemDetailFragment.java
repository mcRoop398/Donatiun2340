package com.example.claireroop.donatiun_2340.Controller;


import android.app.Activity;
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

    public DataItem getmItem() {
        return mItem;
    }

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dataitem_detail, container, false);
        Log.d("MYAPP", "Getting ready to set data");
        // Show the dummy content as text in a TextView.

        addNewDonation("Sean");
        addNewDonation("John");
        addNewDonation("Tommy");


        if (mItem != null) {

            String[] donationID = new String[mItem.getDonationItemsList().size()];
            for(int i = 0; i < donationID.length; i++){
                donationID[i] =  mItem.getDonationItemsList().get(i).name;
            }
            Spinner donationSpinner = rootView.findViewById(R.id.Donations);
            ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, donationID);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            donationSpinner.setAdapter(adapter);

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

    /**
     * Donation Object Constructor needs to variables to pass in
     * Talk to John about what is need in Donation Object
     *
     */
    public void addNewDonation(String name){
        mItem.getDonationItemsList().add(new DonationItem(name,
                "","","","",
                "","",mItem.getDonationItemsList()));
    }

}

