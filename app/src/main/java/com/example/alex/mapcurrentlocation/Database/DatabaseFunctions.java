package com.example.alex.mapcurrentlocation.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by James Nikolaidis on 10/16/2016.
 */
public class DatabaseFunctions extends SQLiteOpenHelper {

    public static final String DatabaseName = "STORES";
    public static final String[] TABLE_COLLUMS = new String[]{"KWDIKOS","ONOMA","DIEYTHINSI","LATITUDE ","LONGTITUDE"};
    public static Context PROGRAM_CONTEXT ;
    private static DatabaseFunctions dbObject;


    private DatabaseFunctions(Context context) {
        super(context, DatabaseName,  null, 1);
        PROGRAM_CONTEXT= context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL("create table if not exist" + DatabaseName + " (KWDIKOS integer primary key ,ONOMA varchar , DIEYTHINSI varchar ,LATITUDE varchar, LONGTITUDE varchar)");
        }catch (Exception ex){

            Toast.makeText(PROGRAM_CONTEXT,"The Database can not be created . Please try again.",Toast.LENGTH_SHORT).show();
        }



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }



    //*******************Create Insert Method for Database
    public void InsertDataToDatabase(String ...Values){
        int counter1 = 1;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        for(int i=0; i<Values.length;i++,counter1++) {

            contentValues.put(TABLE_COLLUMS[counter1],Values[i]);
        }

        try{
            db.insert(DatabaseName, null, contentValues);
            Log.d("Insert","Insert Complete");
        }
        catch (Exception ex){
            Log.d("Insert","Insert InComplete");
        }

    }//*************************End of Insert Method





    public Cursor GetDatabaseData(int position ){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from STORES  where KWDIKOS="+position+"",null );
        return res;

    }



    public Cursor GetDatabase_ALL_DATA(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from STORES ",null );
        return res;

    }


    // *********************   Created By Magdalini Koiou
    private void InsertData(){



        InsertDataToDatabase("Mammas pizza","Κιουταχείας 6","40.268508","22.501781");
        InsertDataToDatabase("Family","Ερμού και Παναγή Τσαλδάρη","37.963928","23.648268");
        InsertDataToDatabase("Coffee island","Ερμού 19","41.089990","23.548625");
        InsertDataToDatabase("Καλύτερος","Μεραρχίας 30","41.088124","23.548523");
        InsertDataToDatabase("Αστόρια","Μεραρχίας 33","40.691612","21.681245");
        InsertDataToDatabase("Το ερατεινό","Βενιζέλου 9","41.089392","23.545757");
        InsertDataToDatabase("Δημοσθένης","Εμμανουήλ Ανδρόνικου 24","41.090035","23.548703");

    }
//********************************************


    //Create Singleton Class
    public DatabaseFunctions GetDatabaseObject(Context context){

        if(dbObject.equals(null)){
            return new DatabaseFunctions(context);

        }
        return  dbObject;
    }
}
