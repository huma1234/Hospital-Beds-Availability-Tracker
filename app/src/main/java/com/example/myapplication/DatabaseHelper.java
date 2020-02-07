package com.example.myapplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "register.db";
    public static final String TABLE_NAME = "registeruser";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "username";
    public static final String COL_3 = "password";
    SQLiteDatabase db;
    public DatabaseHelper(Context context) {


        super(context, DATABASE_NAME, null, 1);
       // context.deleteDatabase(DATABASE_NAME);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE  registeruser(ID INTEGER PRIMARY  KEY AUTOINCREMENT, username TEXT, password TEXT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long addUser(String user, String password) {


        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("username", user);
        contentValues.put("password", password);


        long res=db.insert("registeruser", null, contentValues);
        return res;
    }
    public boolean checkUser(String username, String password){
        String[] columns = { COL_1 };
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_2 + "=?" + " and " + COL_3 + "=?";
        String[] selectionArgs = { username, password };

        Cursor cursor = db.query(TABLE_NAME,columns,selection,selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if(count>0)
            return  true;
        else
            return  false;
}
    public boolean checkUsername(String username){
        String[] columns = { COL_1 };
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_2 + "=?" ;
        String[] selectionArgs = { username};

        Cursor cursor = db.query(TABLE_NAME,columns,selection,selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if(count>0)
            return  true;
        else
            return  false;
    }
    public boolean checkPassword(String password){
        String[] columns = { COL_1 };
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_3 + "=?" ;
        String[] selectionArgs = {password};

        Cursor cursor = db.query(TABLE_NAME,columns,selection,selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if(count>0)
            return  true;
        else
            return  false;
    }
    public void deleteAll()
    {
        //SQLiteDatabase db = this.getWritableDatabase();
        // db.delete(TABLE_NAME,null,null);
        //db.execSQL("delete * from"+ TABLE_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        db.close();
}}