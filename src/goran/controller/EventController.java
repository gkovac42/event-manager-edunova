/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.controller;

import goran.model.Event;
import goran.model.Location;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Goran
 */
public class EventController extends ConnectionController {

    public List<Event> getEvents() {

        List<Event> events = new ArrayList<>();

        try {

            ps = connection.prepareStatement("select * from event");
            rs = ps.executeQuery();
            Event event;

            while (rs.next()) {
                event = new Event();
                event.setId(rs.getInt("id"));
                event.setName(rs.getString("naziv"));
                event.setStartDate(rs.getDate("datum_Pocetak"));
                event.setEndDate(rs.getDate("datum_kraj"));
                event.setLocation(rs.getString("lokacija"));
                events.add(event);
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return events;
    }

    public void addEvent(Event event) {

        try {

            ps = connection.prepareStatement("insert into event(naziv) values (?)");
            ps.setString(1, event.getName());
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editEvent(Event event) {

        try {

            ps = connection.prepareStatement("update event set naziv=? where id=?");
            ps.setString(1, event.getName());
            ps.setInt(2, event.getId());
            ps.execute();

        } catch (Exception e) {
        }
    }

    public void removeEvent(Event event) {

        try {

            ps = connection.prepareStatement("delete from event where id=?");
            ps.setInt(1, event.getId());
            ps.execute();

        } catch (Exception e) {
        }
    }

    public void setEventLocation(Event event, Location location) {

        try {

            ps = connection.prepareStatement("update event set lokacija=? where id=?");
            ps.setString(1, location.toString());
            ps.setInt(2, event.getId());
            ps.execute();
        } catch (Exception e) {
        }
    }

    public String getEventLocation(Event event) {
        
        String location = "";
        
        try {
            ps = connection.prepareStatement("select lokacija from event where id=?");
            ps.setInt(1, event.getId());
            rs = ps.executeQuery();
            
            
            
            while (rs.next()) {
                location = (rs.getString("lokacija"));
                
            }
            
        } catch (SQLException sQLException) {
        }
        
        if (location.equals("")) {
            location = "DODAJ LOKACIJU EVENTA";
        }
        
        return location;
    }
}
