package com.java.ATS.service;

import com.java.ATS.utils.Constants;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class DropBox_Service {

    public String getDataFromDropBoxLink() {
        String output = new String();
        try {

            URL url = new URL(Constants.GET_DROPBOX_LINK);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));


            System.out.println("Output from Server .... \n");
            String line = null;
            while ((line = br.readLine()) != null) {
                //System.out.println(output);
                output += line;

            }
            conn.disconnect();
            System.out.println("Main Output>>>" + output);
            return output;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }



    public ArrayList<String> getFullJSONObject() {
        String jsonString = getDataFromDropBoxLink();
        JSONArray jsonarray = new JSONArray(jsonString);
        System.out.println("JSOn Array is>>>" + jsonarray);

        ArrayList<String> jsonObjectsArray = new ArrayList<String>();

        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            jsonObjectsArray.add(jsonobject.toString());
        }

        return jsonObjectsArray;
    }


    public ArrayList<String> getAddressJSONObject() {
        String jsonString = getDataFromDropBoxLink();
        JSONArray jsonarray = new JSONArray(jsonString);
        System.out.println("JSOn Array is>>>" + jsonarray);

        ArrayList<String> addressjsonObjects = new ArrayList<String>();

        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            addressjsonObjects.add(((JSONObject) jsonobject.get("address")).toString());
        }

        return addressjsonObjects;
    }


    public ArrayList<String> getCityArrayObject() {
        String jsonString = getDataFromDropBoxLink();
        JSONArray jsonarray = new JSONArray(jsonString);

        ArrayList<String> cityjsonArray = new ArrayList<String>();
        ArrayList<JSONObject> addressjsonObjects = new ArrayList<JSONObject>();

        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            addressjsonObjects.add((JSONObject) jsonobject.get("address"));
            cityjsonArray.add(addressjsonObjects.get(i).get("city").toString());
        }
        return cityjsonArray;
    }

    /*public static void main(String[] args) {

        DropBox_Service obj = new DropBox_Service();

        String jsonString = obj.getDataFromDropBoxLink();
        System.out.println("Main JSON String>>>" + jsonString);

        ArrayList<String> addressjsonObject = obj.getAddressJSONObject();
        System.out.println("Address JSON Array>>>" + addressjsonObject);

        ArrayList<String> cityJsonArray = obj.getCityArrayObject();
        System.out.println("City JSOn Array>>>" + cityJsonArray);
    }*/
}
