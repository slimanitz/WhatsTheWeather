package com.example.whatstheweather;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class JSONDownloader extends AsyncTask<String,Void,String> {

    String Main;
    String Description;
    String Json;

    protected String doInBackground(String... urls) {

        try {
            URL url = new URL(urls[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.connect();

            InputStream in = connection.getInputStream();
            Scanner s = new Scanner(in).useDelimiter("\\A");
            String result = s.hasNext() ? s.next() : "";


            Json =result;

            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        try {

            JSONObject jsonObject = new JSONObject(s);
            String weather_info = jsonObject.getString("weather");
            Log.i("Weather", weather_info);

            JSONArray array = new JSONArray(weather_info);

            for (int i = 0 ; i< array.length();i++){
                JSONObject jsonPart = array.getJSONObject(i);
                Main = jsonPart.getString("main");
                Description = jsonPart.getString("description");

            }



        }catch(Exception e ){
            e.printStackTrace();
        }

    }

    public String getMain(){
        try {

            JSONObject jsonObject = new JSONObject(Json);
            String weather_info = jsonObject.getString("weather");
            Log.i("Weather", weather_info);

            JSONArray array = new JSONArray(weather_info);

            for (int i = 0 ; i< array.length();i++){
                JSONObject jsonPart = array.getJSONObject(i);
                Main = jsonPart.getString("main");
                Description = jsonPart.getString("description");

            }



        }catch(Exception e ){
            e.printStackTrace();
        }
        return Main;
    }

    public String getDescription(){
        try {

            JSONObject jsonObject = new JSONObject(Json);
            String weather_info = jsonObject.getString("weather");
            Log.i("Weather", weather_info);

            JSONArray array = new JSONArray(weather_info);

            for (int i = 0 ; i< array.length();i++){
                JSONObject jsonPart = array.getJSONObject(i);
                Main = jsonPart.getString("main");
                Description = jsonPart.getString("description");

            }



        }catch(Exception e ){
            e.printStackTrace();
        }
        return Description;
    }
}
