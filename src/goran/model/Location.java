/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.OneToMany;

/**
 *
 * @author Goran
 */

@javax.persistence.Entity
@javax.persistence.Table
public class Location extends Entity implements Serializable {
    
    private String name;
    private String address;
    private String locality;
    private String country;
    private String lat;
    private String lng;
    @OneToMany
    private List<Event> events;
    
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

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
    
    @Override
    public String toString() {
        return name+ ", " + locality;
    }
    
}
