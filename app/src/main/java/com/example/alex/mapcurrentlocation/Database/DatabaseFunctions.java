package com.example.alex.mapcurrentlocation.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by James Nikolaidis on 10/16/2016.
 */
public class DatabaseFunctions extends SQLiteOpenHelper {

    public static final String DatabaseName = "STORES";
    public static final String[] TABLE_COLLUMS = new String[]{"KWDIKOS","ONOMA","DIEYTHINSI","LATITUDE ","LONGTITUDE"};
    public static Context PROGRAM_CONTEXT ;
    private static DatabaseFunctions database;



    private DatabaseFunctions(Context context) {
        super(context, DatabaseName,  null, 1);
        PROGRAM_CONTEXT= context;
        InsertData();

    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL("create table IF NOT EXISTS STORES (KWDIKOS integer primary key ,ONOMA varchar , DIEYTHINSI varchar ,LATITUDE varchar, LONGTITUDE varchar)");
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


        for(int i=0; i!=Values.length;i++,counter1++) {
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





// *********************   Get All data from the one row of the table

    public Cursor GetDatabaseData(int position ){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from STORES  where KWDIKOS="+position+"",null );
        return res;

    }
//*****************END



    // *********************   Get All data from the Table
    public Cursor GetDatabase_ALL_DATA() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from STORES ", null);
        return res;

    }
    // ********************* END




    // *********************Created By Magdalini Koiou
    public void InsertData(){

        Log.d("Message","Database");
        InsertDataToDatabase("Το ερατεινό","Βενιζέλου 9","41.089392","23.545757");
        InsertDataToDatabase("Δημοσθένης","Εμμανουήλ Ανδρόνικου 24","41.090035","23.548703");
        InsertDataToDatabase("Mammas pizza","Κιουταχείας 6","41.0863173","23.541439999999966");
        InsertDataToDatabase("Family","Ερμού και Παναγή Τσαλδάρη","41.0896086","23.547109699999964");
        InsertDataToDatabase("Coffee island","Ερμού 19","41.089990","23.548625");
        InsertDataToDatabase("Καλύτερος","Μεραρχίας 30","41.088124","23.548523");
        InsertDataToDatabase("Αστόρια","Μεραρχίας 33","41.0880907","23.54861310000001");
        InsertDataToDatabase("Mikel Ευόσμου","Καραολή & Δημητρίου 92","40.6666706","22.911326199999962");
        InsertDataToDatabase("Hondos Center","Π. Μελά 31","40.6685303","22.908910900000024");
        InsertDataToDatabase("BEAVER Coffee & Drinks","Αμπελώνων 43 αμπελοκηποι","40.6498717","22.925945100000035");
        InsertDataToDatabase("WHY","Ηφαίστου 11, 62100 ","41.0891809","23.54759880000006");
        InsertDataToDatabase("Seven Spot","Εθνικής Αντιστάσεως 64 Κορδελιό","40.6698528","22.89730480000003");
        InsertDataToDatabase("Ψιλικατζίδικο"," Πολυτεχνείου 50 Κορδελιό","40.6718655","22.89588200000003");
        InsertDataToDatabase("Vodafone","Παπανδρέου Ανδρέα 28","40.6682429","22.894566899999973");


    }
//********************************************


    //*********   Database Singleton Begin

    public  static  DatabaseFunctions getInstance(Context context){
        if(database==null){

            database = new DatabaseFunctions(context);
        }
        return database;

    }
    //*********   Database Singleton End


}
