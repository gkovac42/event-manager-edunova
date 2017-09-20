/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author Goran
 */
@javax.persistence.Entity
@javax.persistence.Table (name = "ticket_store")
public class Ticket extends Entity implements Serializable {

    private String name;
    private Double price;
    private int quantity;
    @ManyToOne
    private Event event;
    @ManyToMany
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return name + " - " + new DecimalFormat("#.00").format(price) + "kn" + " - " + quantity + " kom.";
    }

    public String getTotalPrice() {
        double totalPrice = this.getPrice() * this.getQuantity();
        return new DecimalFormat("#.00").format(totalPrice) + "kn";
    }

}
