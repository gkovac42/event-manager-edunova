/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.controller;

import goran.model.Location;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Goran
 */
public class LocationController extends ConnectionController {

    public List<Location> getLocations() {

        List<Location> locations = new ArrayList<>();

        try {

            ps = connection.prepareStatement("select * from lokacija");
            rs = ps.executeQuery();
            Location location;

            while (rs.next()) {
                location = new Location();
                location.setId(rs.getInt("id"));
                location.setName(rs.getString("naziv"));
                location.setAddress(rs.getString("adresa"));
                location.setLocality(rs.getString("mjesto"));
                location.setCountry(rs.getString("drzava"));
                location.setLat(rs.getString("lat"));
                location.setLng(rs.getString("lng"));
                locations.add(location);
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return locations;
    }

    public void addLocation(Location location) {

        try {

            ps = connection.prepareStatement("insert into lokacija (naziv,adresa,mjesto,drzava,lat,lng) values (?,?,?,?,?,?)");
            ps.setString(1, location.getName());
            ps.setString(2, location.getAddress());
            ps.setString(3, location.getLocality());
            ps.setString(4, location.getCountry());
            ps.setString(5, location.getLat());
            ps.setString(6, location.getLng());
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editLocation(Location location) {

        try {

            ps = connection.prepareStatement("update lokacija set naziv=?, adresa=?, mjesto=?, drzava=?, lat=?, lng=? where id=?");
            ps.setString(1, location.getName());
            ps.setString(2, location.getAddress());
            ps.setString(3, location.getLocality());
            ps.setString(4, location.getCountry());
            ps.setString(5, location.getLat());
            ps.setString(6, location.getLng());
            ps.setInt(7, location.getId());
            ps.execute();

        } catch (Exception e) {
        }
    }

    public void removeLocation(Location location) {
        try {

            ps = connection.prepareStatement("delete from lokacija where id=?");
            ps.setInt(1, location.getId());
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
