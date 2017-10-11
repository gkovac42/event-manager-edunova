/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Goran
 */
@javax.persistence.Entity
@javax.persistence.Table (name = "order_details")
public class Order extends goran.model.Entity implements Serializable {

    @ManyToOne
    private Customer customer;
    @OneToMany
    private List<OrderedTicket> orderedTickets;
    
    public Order() {
        orderedTickets = new ArrayList<>();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderedTicket> getTickets() {
        return orderedTickets;
    }

    public void setTickets(List<OrderedTicket> tickets) {
        this.orderedTickets = tickets;
    }

    public String getTotalPrice() {
        double totalPrice = 0;
        for (OrderedTicket t : orderedTickets) {
            totalPrice += t.getTicket().getPrice() * t.getQuantity();
        }
        return new DecimalFormat("#.00").format(totalPrice) + "kn";
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        return "Narudžba #" + this.getId().toString() + " od " + df.format(this.getDateCreated());
    }
    
    
}
