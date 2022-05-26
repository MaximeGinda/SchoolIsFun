package com.example.schoolisfun.data;

import android.util.Log;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Converters {
    @TypeConverter
    public static ArrayList<String> fromString(String value) {
        Type listType = new TypeToken<ArrayList<String>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(ArrayList<String> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    @TypeConverter
    public static ArrayList<Boolean> fromBool(String value) {
        ArrayList<Boolean> returnAL = new ArrayList<Boolean>();

        for(int i = 0; i < value.length(); i++){
            if( value.charAt(i) == '0' ){
                returnAL.add(false);
            }
            else if ( value.charAt(i) == '1' ){
                returnAL.add(true);
            }
        }
        return returnAL;
    }

    @TypeConverter
    public static String fromArrayListOfBool(ArrayList<Boolean> list) {
        String returnString = "";
        for(int i = 0; i < list.size(); i++){
            String toAdd;
            if(list.get(i))
                 toAdd = "1";
            else toAdd = "0";
            returnString = returnString +"-"+ toAdd;
        }
        return returnString;
    }


}