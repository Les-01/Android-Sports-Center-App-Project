package com.example.exeriversports;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBFunctions extends SQLiteOpenHelper {

    // This declares the string variable 'DBNAME' and assigns the value 'Login.db'.
    public static final String DBNAME = "Login.db";

    // This creates the database 'Login.db'
    public DBFunctions(Context context) {
        super(context, "Login.db", null, 1);
    }

    // This SQLite query will create a table in the database.
    @Override
    public void onCreate(SQLiteDatabase Exe_River_Sports_DB) {
        Exe_River_Sports_DB.execSQL("create Table members(email TEXT primary key, firstname TEXT, lastname TEXT, password TEXT)");

    }

    // This will delete the member table if one already exists
    @Override
    public void onUpgrade(SQLiteDatabase Exe_River_Sports_DB, int i, int i1) {
        Exe_River_Sports_DB.execSQL("drop Table if exists members");
    }

    // SQLite query will insert data into the members table in the database.
    public Boolean insertData(String email, String firstname, String lastname, String password) {
        SQLiteDatabase Exe_River_Sports_DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("firstname", firstname);
        contentValues.put("lastname", lastname);
        contentValues.put("password", password);
        long result = Exe_River_Sports_DB.insert("members", null, contentValues);
        // If SQLite insert query fails return false
        if (result == -1) {
            return false;
        } else {
            // If SQLite insert query does not fail return true
            return true;
        }
    }

    // This function checks if the email is already stored in the members table within the database.
    public Boolean checkemail(String email) {
        SQLiteDatabase Exe_River_Sports_DB = this.getWritableDatabase();
        Cursor cursor = Exe_River_Sports_DB.rawQuery("Select * from members where email = ?", new String[]{email});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    // This function checks if the login details match the records stored in the members table within the database.
    public Boolean checklogin(String email, String password) {
        SQLiteDatabase Exe_River_Sports_DB = this.getWritableDatabase();
        Cursor cursor = Exe_River_Sports_DB.rawQuery("Select * from members where email = ? and password = ?", new String[]{email, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    // This function updates the users details where the users email matches the record stored in the members table within the database.
    public Boolean updateData(String FirstName, String LastName, String Email, String Password)
    {
        SQLiteDatabase Exe_River_Sports_DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("firstname", FirstName);
        contentValues.put("lastname", LastName);
        contentValues.put("password", Password);
        Cursor cursor = Exe_River_Sports_DB.rawQuery("Select * from members where email = ?", new String[] {Email});
        if(cursor.getCount()>0)
        {
            long result = Exe_River_Sports_DB.update("members", contentValues, "email=?", new String[]{Email});
            // If SQLite insert query fails return false
            if (result == -1)
            {
                return false;
            }
            else
            {
                // If SQLite insert query does not fail return true
                return true;
            }
        }
        else
        {
            return false;
        }
    }

    // This function deletes the users details where the users email matches the record stored in the members table within the database.
    public Boolean deleteData(String Email)
    {
        SQLiteDatabase Exe_River_Sports_DB = this.getWritableDatabase();
        Cursor cursor = Exe_River_Sports_DB.rawQuery("Select * from members where email = ?", new String[] {Email});
        if(cursor.getCount()>0)
        {
            long result = Exe_River_Sports_DB.delete("members", "email=?", new String[]{Email});
            // If SQLite insert query fails return false
            if (result == -1)
            {
                return false;
            }
            else
            {
                // If SQLite insert query does not fail return true
                return true;
            }
        }
        else
        {
            return false;
        }
    }

    // This function selects the users details where the users email matches the record stored in the members table within the database.
    public Cursor getdata(String Email)
    {
        SQLiteDatabase Exe_River_Sports_DB = this.getWritableDatabase();
        Cursor cursor = Exe_River_Sports_DB.rawQuery("Select * from members where email = ?", new String[] {Email});
        return cursor;
    }
}