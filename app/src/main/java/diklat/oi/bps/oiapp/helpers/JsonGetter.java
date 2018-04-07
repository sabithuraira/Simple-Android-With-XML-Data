package diklat.oi.bps.oiapp.helpers;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

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

import diklat.oi.bps.oiapp.models.TitleIsi;
import diklat.oi.bps.oiapp.models.TitleTable;

/**
 * Created by sabithuraira on 4/2/18.
 */

public class JsonGetter {
    private Context context;

    public JsonGetter(Context context){
        this.context=context;
    }

    public TitleTable[] getDinasTitle(String name){
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

        JsonElement jelement = new JsonParser().parse(jsonString);
        JsonObject jobject =  (JsonObject)jelement;
        JsonElement jarray = jobject.getAsJsonArray(name);


        Gson gson = new Gson();
        return gson.fromJson(jarray, new TypeToken<TitleTable[]>(){}.getType());
    }


    public TitleIsi[] getDinasIsi(String name){
        int jsonFile = this.context.getResources().getIdentifier("data_dinas_isi", "raw", context.getPackageName());
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
        catch(UnsupportedEncodingException e){}
        catch(IOException e){}

        String jsonString =  writer.toString();

        JsonElement jelement = new JsonParser().parse(jsonString);
        JsonObject jobject =  (JsonObject)jelement;
        JsonElement jarray = jobject.getAsJsonArray(name);

        Gson gson = new Gson();
        return gson.fromJson(jarray, new TypeToken<TitleIsi[]>(){}.getType());
    }
}
