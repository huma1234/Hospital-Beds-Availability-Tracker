package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class preferneceUtils {

    public preferneceUtils(){
    }

    public static boolean saveIsLogedIn(String bool, Context context){
        return save(bool,Constants.isLoggedIn,context);
    }

    public static  String getIsLogedIn(Context context)
    {
        return get(Constants.isLoggedIn,context);
    }
    public static boolean saveUserName(String bool, Context context){
        return save(bool,Constants.userName,context);
    }

    public static  String getUserName(Context context)
    {
        return get(Constants.userName,context);
    }

    public static boolean save(String value, String constant, Context context){
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(constant,value);
        editor.apply();
        return true;
    }

    public static String get(String value, Context context){
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(value,null);
    }
}
