package com.example.alex.mapcurrentlocation.Software;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by James Nikolaidis on 10/19/2016.
 */
public class General_Functions {

    private static float  lon,lat ;
    private  static  Context APPLICATION_CONTEXT;
    private static int THRESHOLD_DISTANCE = 2; // IN KM


    public void GeneralFunctions(Context context){
        APPLICATION_CONTEXT=context;
    }

    public void GiveLan_Lon(float ...coordinates){

        lon = coordinates[0];
        lat = coordinates[1];
    }

    public ArrayList<Float> CompareLon_And_Lat(){
        //COMPARES USERS LAT,LON WITH THE STORES LAN-LON COORDINATES INSIDE THE DATABASE , AND RETURN A ARRAY LIST WITH THE VALUES OF
        //THE SHOPS THAT ARE WITHIN THE PERMITTED THRESHOLD DISTANCE.



       return null;
    }











}
