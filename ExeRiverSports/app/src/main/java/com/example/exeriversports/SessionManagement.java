package com.example.exeriversports;

import android.content.Context;
import android.content.SharedPreferences;

// This declares the class SessionManagement
public class SessionManagement {
    // This declares variable for sharedPreferences.
    SharedPreferences sharedPreferences;

    // This declares variable for the sharedPreferences editor.
    SharedPreferences.Editor editor;

    // This declares variable for SHARED_PREF_NAME and assigns a string value to it.
    String SHARED_PREF_NAME = "session";

    // This declares variable for SESSION_KEY and assigns a string value to it.
    String SESSION_KEY = "session_user";

    // This is the callable 'SessionManagement' method, it defines the functions of the variables.
    public SessionManagement(Context context){
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    // This is the callable 'saveSession' method which saves the session of the user once they are logged in.
    public void saveSession(User user){
        String Email = user.getEmail();

        editor.putString(SESSION_KEY, Email).commit();
    }

    // This is the callable 'getSession' method which will retrieve the value stored in 'SESSION_KEY', if no value exists it will get the value '"No_Session"' by default.
    public String getSession(){
        return sharedPreferences.getString(SESSION_KEY, "No_Session");
    }

    // This is the callable 'removeSession' method which will remove the value stored in 'SESSION_KEY'.
    public void removeSession() {
        editor.putString(SESSION_KEY, "No_Session").commit();
    }
}