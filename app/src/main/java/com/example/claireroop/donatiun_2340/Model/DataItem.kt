package com.example.claireroop.donatiun_2340.Model

import android.app.Activity
import android.widget.ArrayAdapter

import java.util.ArrayList

/**
 * Created by robertwaters on 9/18/17.
 * Edited by Darby Foster on 10/12/18.
 *
 *
 * DataItem: each individual location
 */


class DataItem(
        /**
         * GETTERS
         */

        var key: Int, var name: String?, var latitude: Double, var longitude: Double,
        var address: String?, var city: String?, var state: String?, var zip: Double, var type: String?,
        var phone: String?, var website: String?) {

    private var donationItemsList: ArrayList<DataItem>? = null
    var listContainedIn: ArrayList<DataItem>

    init {
        this.donationItemsList = ArrayList<DataItem>()
        listContainedIn = SimpleModel.INSTANCE.items as ArrayList<DataItem>
    }


    override fun toString(): String {
        return "$name - $key"
    }

    fun getDonationItemsList(): ArrayList<DataItem>? {
        return donationItemsList
    }


    /**
     * SETTERS
     */

    fun setDonationItemsList(donationItemsList: ArrayList<DataItem>) {
        this.donationItemsList = donationItemsList
    }

    fun getItem(i: Int): DonationItem {
        return this.getItem(i)
    }
}