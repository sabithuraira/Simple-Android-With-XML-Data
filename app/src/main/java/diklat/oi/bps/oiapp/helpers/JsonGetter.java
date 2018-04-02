package diklat.oi.bps.oiapp.helpers;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sabithuraira on 4/2/18.
 */

public class JsonGetter {
    private Context context;
    private String name = "";

    public JsonGetter(Context context, String name){
        this.context=context;
        this.name = name;
    }

    public String[] getJsonTitle(){
        List<String> result = new ArrayList<String>();

        int jsonFile = this.context.getResources().getIdentifier("data_dinas", "raw", context.getPackageName());
        InputStream is = this.context.getResources().openRawResource(jsonFile);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
            is.close();
        }
        catch(UnsupportedEncodingException e){

        }
        catch(IOException e){

        }

        String jsonString =  writer.toString();
//
//        Gson gson = new Gson();
//        return gson.fromJson(jsonString, new TypeToken<String[]>(){}.getType());

        JsonElement jelement = new JsonParser().parse(jsonString);
        JsonArray jobject = jelement.getAsJsonArray(). getAsJsonArray(name);
    }

//    public ArrayList<Venue> getJsonVenues(){
//        int jsonFile = this.context.getResources().getIdentifier("venues", "raw", context.getPackageName());
//        InputStream is = this.context.getResources().openRawResource(jsonFile);
//        Writer writer = new StringWriter();
//        char[] buffer = new char[1024];
//        try {
//            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
//            int n;
//            while ((n = reader.read(buffer)) != -1) {
//                writer.write(buffer, 0, n);
//            }
//            is.close();
//        }
//        catch(UnsupportedEncodingException e){
//
//        }
//        catch(IOException e){
//
//        }
//
//        String jsonString =  writer.toString();
//
//        Gson gson = new Gson();
//        return gson.fromJson(jsonString, new TypeToken<ArrayList<Venue>>(){}.getType());
//    }
//
//    public ArrayList<Transportation> getJsonTransportation(){
//        int jsonFile = this.context.getResources().getIdentifier("transportations", "raw", context.getPackageName());
//        InputStream is = this.context.getResources().openRawResource(jsonFile);
//        Writer writer = new StringWriter();
//        char[] buffer = new char[1024];
//        try {
//            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
//            int n;
//            while ((n = reader.read(buffer)) != -1) {
//                writer.write(buffer, 0, n);
//            }
//            is.close();
//        }
//        catch(UnsupportedEncodingException e){
//
//        }
//        catch(IOException e){
//
//        }
//
//        String jsonString =  writer.toString();
//
//        Gson gson = new Gson();
//        return gson.fromJson(jsonString, new TypeToken<ArrayList<Transportation>>(){}.getType());
//    }
}
