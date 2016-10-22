package com.example.alex.mapcurrentlocation.Software;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.alex.mapcurrentlocation.Database.DatabaseFunctions;

import java.util.ArrayList;

/**
 * Created by James Nikolaidis on 10/19/2016.
 */
public class General_Functions {

    private static float  lon,lat ;
    private  static  Context APPLICATION_CONTEXT;
    private static int THRESHOLD_DISTANCE = 2; // IN KM
    private DatabaseFunctions databaseFunctions ;

    public void GeneralFunctions(Context context){
        APPLICATION_CONTEXT=context;
    }

    public void GiveLan_Lon(float ...coordinates){

        lon = coordinates[0];
        lat = coordinates[1];
    }

    public ArrayList<String> CompareLon_And_Lat(){
        //COMPARES USERS LAT,LON WITH THE STORES LAN-LON COORDINATES INSIDE THE DATABASE , AND RETURN A ARRAY LIST WITH THE VALUES OF
        //THE SHOPS THAT ARE WITHIN THE PERMITTED THRESHOLD DISTANCE.
        databaseFunctions = DatabaseFunctions.GetDatabaseObject(APPLICATION_CONTEXT);
        ArrayList<String>Passes_Stores = new ArrayList<>();

        if(databaseFunctions!=null){
            String[] Database_Lon_Lan = new String[2];
            Cursor database_data = databaseFunctions.GetDatabase_ALL_DATA();
            database_data.moveToFirst();
            int counter2 = 1;
            for(int counter1=0; counter1!=database_data.getColumnCount();counter1++,counter2++){

                if(lon-Float.parseFloat(database_data.getString(database_data.getColumnIndex("LONGTITUDE")))<THRESHOLD_DISTANCE && lat-Float.parseFloat(database_data.getString(database_data.getColumnIndex("LATITUDE")))<THRESHOLD_DISTANCE ){

                    try {
                        Passes_Stores.add(database_data.getString(database_data.getColumnIndex("ONOMA")));
                        Passes_Stores.add(database_data.getString(database_data.getColumnIndex("DIEYTHINSI")));
                        Passes_Stores.add(database_data.getString(database_data.getColumnIndex("LONGTITUDE")));
                        Passes_Stores.add(database_data.getString(database_data.getColumnIndex("LATITUDE")));
                        Log.d("System_Message", "Insert was Succesfull");
                    }catch (Exception ex){
                        Log.d("System_Message", "Insert was UnSuccesfull");
                    }
                }else{
                    database_data.moveToNext();
                }
                database_data.moveToNext();
            }
        }
        return null;
    }
}
