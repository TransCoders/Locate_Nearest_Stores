package com.example.alex.mapcurrentlocation;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by tasos on 17/10/2016.
 */

public class MyLocationListenerNetwork implements LocationListener {

    private double nlat;
    private double nlng;


    private LocationManager nlocManager;
    private LocationListener nlocListener;
    private TextView textViewNetLat;
    private TextView textViewNetLng;



    @Override
    public void onLocationChanged(Location loc) {
        nlat = loc.getLatitude();
        nlng = loc.getLongitude();

        //Setting the Network Lat, Lng into the textView
        textViewNetLat.setText("Network Latitude:  " + nlat);
        textViewNetLng.setText("Network Longitude:  " + nlng);

        Log.d("LAT & LNG Network:", nlat + " " + nlng);
    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.d("LOG", "Network is OFF!");
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.d("LOG", "Thanks for enabling Network !");
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }
}