package com.example.webgymglish.model;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * verifInternet class
 *
 * Created by Jean-Christophe THEULIER on 02/07/2019.
 */


public class verifInternet {

    public boolean isConnectedNetwork(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo () != null && cm.getActiveNetworkInfo ().isConnectedOrConnecting ();

    }
}
