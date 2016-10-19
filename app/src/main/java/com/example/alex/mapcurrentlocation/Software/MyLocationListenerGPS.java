package com.example.alex.mapcurrentlocation.Software;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by tasos on 17/10/2016.
 */

public class MyLocationListenerGPS implements LocationListener {

    private double glat;
    private double glng;

    private LocationManager glocManager;
    private LocationListener glocListener;
    private TextView textViewGpsLat;
    private TextView textViewGpsLng;


    @Override
    public void onLocationChanged(Location loc) {
        glat = loc.getLatitude();
        glng = loc.getLongitude();

        //Setting the GPS Lat, Lng into the textView
        textViewGpsLat.setText("GPS Latitude:  " + glat);
        textViewGpsLng.setText("GPS Longitude:  " + glng);

        Log.d("LAT & LNG GPS:", glat + " " + glng);
    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.d("LOG", "GPS is OFF!");
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.d("LOG", "Thanks for enabling GPS !");
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }
}