/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.controller;

import goran.model.Event;
import goran.model.Ticket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Goran
 */
public class TicketController extends ConnectionController {

    public List<Ticket> getTickets() {

        List<Ticket> tickets = new ArrayList<>();

        try {

            ps = connection.prepareStatement("select * from ulaznica");
            rs = ps.executeQuery();
            Ticket ticket;

            while (rs.next()) {
                ticket = new Ticket();
                ticket.setId(rs.getInt("id"));
                ticket.setName(rs.getString("naziv"));
                ticket.setPrice(rs.getDouble("cijena"));
                ticket.setEvent(rs.getInt("event"));
                tickets.add(ticket);
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return tickets;
    }
    
    public List<Ticket> getEventTickets(Event event) {
        
        List<Ticket> eventTickets = new ArrayList<>();

        try {

            ps = connection.prepareStatement("select * from ulaznica where event=?");
            ps.setInt(1, event.getId());
            rs = ps.executeQuery();
            Ticket ticket;

            while (rs.next()) {
                ticket = new Ticket();
                ticket.setId(rs.getInt("id"));
                ticket.setName(rs.getString("naziv"));
                ticket.setPrice(rs.getDouble("cijena"));
                ticket.setEvent(rs.getInt("event"));
                eventTickets.add(ticket);
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return eventTickets;
        
    }

    public void addTicket(Ticket ticket) {

        try {

            ps = connection.prepareStatement("insert into ulaznica(naziv, cijena, event) values (?,?,?)");
            ps.setString(1, ticket.getName());
            ps.setDouble(2, ticket.getPrice());
            ps.setInt(3, ticket.getEvent());
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editTicket(Ticket ticket) {

        try {

            ps = connection.prepareStatement("update ulaznica set naziv=?, cijena=?, event=? where id=?");
            ps.setString(1, ticket.getName());
            ps.setDouble(2, ticket.getPrice());
            ps.setInt(3, ticket.getEvent());
            ps.setInt(4, ticket.getId());
            ps.execute();

        } catch (Exception e) {
        }
    }

    public void removeTicket(Ticket ticket) {

        try {

            ps = connection.prepareStatement("delete from ulaznica where id=?");
            ps.setInt(1, ticket.getId());
            ps.execute();

        } catch (Exception e) {
        }
    }
    
    public void removeEventTickets(Event event) {
        
        try {

            ps = connection.prepareStatement("delete from ulaznica where event=?");
            ps.setInt(1, event.getId());
            ps.execute();

        } catch (Exception e) {
        } 
    }
    
    public List<Ticket> findTickets(String s) {

        List<Ticket> tickets = new ArrayList<>();

        try {

            ps = connection.prepareStatement("select * from ulaznica where naziv like '%" + s + "%'");
            rs = ps.executeQuery();
            Ticket ticket;

            while (rs.next()) {
                ticket = new Ticket();
                ticket.setId(rs.getInt("id"));
                ticket.setName(rs.getString("naziv"));
                ticket.setPrice(rs.getDouble("cijena"));
                ticket.setEvent(rs.getInt("event"));
                tickets.add(ticket);
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return tickets;
    }
}
