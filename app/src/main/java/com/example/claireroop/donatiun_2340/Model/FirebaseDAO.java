package com.example.claireroop.donatiun_2340.Model;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A DAO backed by firebase.
 */

@SuppressWarnings("ALL")
public class FirebaseDAO extends DummyDAO implements ValueEventListener {
    final FirebaseDatabase database;
    final DatabaseReference root;

    @SuppressWarnings("ThisEscapedInObjectConstruction")
    FirebaseDAO() {
        database = FirebaseDatabase.getInstance();
        root = database.getReference();
        root.child("users").addValueEventListener(this);
        //root.child("waterSourceReports").addValueEventListener(this);
        //root.child("waterPurityReports").addValueEventListener(this);
        //root.child("logEvents").addValueEventListener(this);
        database.goOnline();
    }

//    @Override
//    public void addWaterSourceReport(WaterSourceReport waterSourceReport) {
//        root.child("waterSourceReports").push().setValue(waterSourceReport);
//    }
//
//    @Override
//    public void addWaterPurityReport(WaterPurityReport waterPurityReport) {
//        root.child("waterPurityReports").push().setValue(waterPurityReport);
//    }

    @Override
    public void addAccount(Account account) {
        root.child("accounts").child(account.get_id()).setValue(account);
    }

//    @Override
//    public void addLogEvent(LogEvent logEvent) {
//        root.child("logEvents").push().setValue(logEvent);
//    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        switch (dataSnapshot.getRef().getKey()) {
//            case "waterPurityReports":
//                waterPurityReports =
//                        iterableToList(WaterPurityReport.class, dataSnapshot.getChildren());
//                break;
//            case "waterSourceReports":
//                waterSourceReports =
//                        iterableToList(WaterSourceReport.class, dataSnapshot.getChildren());
//                break;
            case "users":
                accounts = iterableToList(Account.class, dataSnapshot.getChildren());
                break;
//            case "logEvents":
//                logEvents = iterableToList(LogEvent.class, dataSnapshot.getChildren());
//                break;
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        // TODO: handle an error
        throw databaseError.toException();
    }

    private <T> List<T> iterableToList(Class cls, Iterable<DataSnapshot> iterable) {
        List<T> list = new ArrayList();
        for(DataSnapshot dataSnapshot : iterable) {
            list.add((T) dataSnapshot.getValue(cls));
        }
        return list;
    }
}
