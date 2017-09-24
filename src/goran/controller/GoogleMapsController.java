/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import goran.model.Location;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Goran
 */
public class GoogleMapsController {

    private final String API_KEY = "AIzaSyATHO_6DIs4uKZNZJo50n95QERyy2Np13w";

    public String generateUrl(Location location) {

        String url = "";

        try {
            url = "https://maps.googleapis.com/maps/api/geocode/json?"
                    + "address=" + URLEncoder.encode(location.getName(), "UTF-8")
                    + ",+" + URLEncoder.encode(location.getAddress(), "UTF-8")
                    + ",+" + URLEncoder.encode(location.getLocality(), "UTF-8")
                    + ",+" + URLEncoder.encode(location.getCountry(), "UTF-8")
                    + "&key=" + API_KEY;

        } catch (UnsupportedEncodingException ex) {
        }

        return url;

    }

    public String[] getGoogleMapsData(String generatedUrl) {

        try {

            String[] data = {"", "", "", "", "", ""};

            URL url = new URL(generatedUrl);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            JsonParser parser = new JsonParser();
            JsonElement content = parser.parse(new InputStreamReader((InputStream) request.getContent()));

            JsonObject jObject = content.getAsJsonObject();
            JsonArray results = jObject.getAsJsonArray("results");
            jObject = results.get(0).getAsJsonObject().getAsJsonObject("geometry").getAsJsonObject("location");

            data[0] = jObject.get("lat").getAsString();
            data[1] = jObject.get("lng").getAsString();

            JsonArray addressComponents = results.get(0).getAsJsonObject().getAsJsonArray("address_components");

            for (int i = 0; i < addressComponents.size(); i++) {

                jObject = addressComponents.get(i).getAsJsonObject();
                JsonArray types = jObject.getAsJsonArray("types");
                String type = types.get(0).getAsString();

                String component = jObject.get("long_name").getAsString();

                if (type.matches("street_number")) {
                    data[2] = component;
                } else if (type.matches("route")) {
                    data[3] = component;
                } else if (type.matches("locality")) {
                    data[4] = component;
                } else if (type.matches("country")) {
                    data[5] = component;
                }

            }

            return data;

        } catch (MalformedURLException ex) {
            ex.printStackTrace();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void downloadMap(String lat, String lng, int zoomLevel, JLabel lblMap) {

        Thread t = new Thread(() -> {
            
            String imageUrl = "http://maps.googleapis.com/maps/api/staticmap?center="
                    + lat + ",%20" + lng + "&zoom=" + zoomLevel + "&size=" + lblMap.getWidth()+ "x" + lblMap.getHeight()
                    + "&scale=1&markers=" + lat + ",%20" + lng + "&sensor=true";
            try {
                
                URL url = new URL(imageUrl);
                lblMap.setIcon(new ImageIcon(new ImageIcon(url).getImage().
                        getScaledInstance(lblMap.getWidth(), lblMap.getHeight(), java.awt.Image.SCALE_SMOOTH)));
                
            } catch (MalformedURLException ex) {
            }
        });

        t.start();
    }
}
