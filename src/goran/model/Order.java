/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author Goran
 */
@javax.persistence.Entity
@javax.persistence.Table (name = "order_details")
public class Order extends goran.model.Entity implements Serializable {

    @ManyToOne
    private Customer customer;
    @ManyToMany
    private List<Ticket> tickets;
    
    public Order() {
        tickets = new ArrayList<>();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Ticket ticket : tickets) {
            totalPrice += ticket.getPrice() * ticket.getQuantity();
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        return "Narudžba #" + this.getId().toString() + " od " + this.getDateCreated();
    }
    
    
}
