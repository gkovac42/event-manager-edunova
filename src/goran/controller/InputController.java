/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.controller;

import goran.model.Customer;
import goran.model.Event;
import goran.model.Location;
import goran.model.Ticket;

/**
 *
 * @author Goran
 */
public class InputController {

    public static boolean customerInputError(Customer c) {
        return c.getFirstName().equals("") || c.getLastName().equals("") || c.getAddress().equals("")
                || c.getLocality().equals("") || c.getEmail().equals("");
    }

    public static boolean locationInputError(Location l) {
        return l.getName().equals("") || l.getAddress().equals("") || l.getLocality().equals("") || l.getCountry().equals("");
    }

    public static boolean ticketInputError(Ticket t, String price, String quantity) {
        return t.getName().equals("") || price.equals("") || quantity.equals("");
    }
    
    public static boolean eventInputError(Event e) {
        return e.getName().equals("");
    }
}
