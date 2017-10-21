/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.model;

import java.io.Serializable;
import java.text.DecimalFormat;
import javax.persistence.ManyToOne;

/**
 *
 * @author Goran
 */
@javax.persistence.Entity
@javax.persistence.Table
public class OrderedTicket extends Entity implements Serializable {
    
    @ManyToOne
    private Ticket ticket;
    @ManyToOne
    private Order order;
    private int quantity;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public double getTotalPrice() {
        double totalPrice = ticket.getPrice() * this.getQuantity();
        return totalPrice;
    }

    @Override
    public String toString() {
        return ticket.getName() + "   x" + quantity + " - " + new DecimalFormat("#.00kn").format(getTotalPrice());
    }
    
    
    
}
