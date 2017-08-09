/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.model;

/**
 *
 * @author Goran
 */
public class Location extends Entity {
    
    private String name;
    private String address;
    private String locality;
    private String country;
    private String lat;
    private String lng;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String Address) {
        this.address = Address;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String Locality) {
        this.locality = Locality;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String Country) {
        this.country = Country;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return name+ ", " + locality;
    }
    
}
