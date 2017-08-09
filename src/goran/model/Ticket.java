/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.model;

import java.text.DecimalFormat;

/**
 *
 * @author Goran
 */
public class Ticket extends Entity {
    
    private String name;
    private Double price;
    private int Event;

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

    public int getEvent() {
        return Event;
    }

    public void setEvent(int Event) {
        this.Event = Event;
    }

    @Override
    public String toString() {
        return name + " - " + new DecimalFormat("#.00").format(price) + "kn";
    }
    
    
}
