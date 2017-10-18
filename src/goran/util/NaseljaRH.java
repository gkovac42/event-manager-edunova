/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Goran
 */
public class NaseljaRH {

    public static List<String> popisNaselja = new ArrayList<>();

    //private static final String NASELJA_URL =
    //"https://raw.githubusercontent.com/ndekic/popis_naselja_u_republici_hrvatskoj/master/json/popis_naselja_u_republici_hrvatskoj.json";
    
    private static final String JSON_PATH = "data/naselja.json";
    
    public NaseljaRH() {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(JSON_PATH), "UTF-8"));
            JsonParser parser = new JsonParser();
            JsonArray naselja = parser.parse(br).getAsJsonArray();

            for (int i = 0; i < naselja.size(); i++) {
                JsonObject naselje = naselja.get(i).getAsJsonObject();
                String naziv = naselje.get("mjesto").getAsString() + " (" + naselje.get("postanskiBroj") + ")";
                naziv = naziv.replace("\"", "");
                NaseljaRH.popisNaselja.add(naziv);
            }

            br.close();

        } catch (Exception ex) {
            Logger.getLogger(NaseljaRH.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
