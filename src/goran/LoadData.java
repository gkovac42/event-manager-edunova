/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran;

import goran.controller.HibernateController;
import goran.model.Customer;
import goran.model.Event;
import goran.model.Location;
import goran.model.Order;
import goran.model.OrderedTicket;
import goran.model.Ticket;
import java.util.List;

/**
 *
 * @author Goran
 */
public class LoadData {

    private HibernateController<Customer> ctrlCustomer = new HibernateController<>();
    private HibernateController<Event> ctrlEvent = new HibernateController<>();
    private HibernateController<Ticket> ctrlTicket = new HibernateController<>();
    private HibernateController<Order> ctrlOrder = new HibernateController<>();
    private HibernateController<OrderedTicket> ctrlOrderedTicket = new HibernateController<>();
    private HibernateController<Location> ctrlLocation = new HibernateController<>();

    public LoadData() {

        loadLocations();
        loadEventsTickets();
        loadCustomers();

    }

    private void loadLocations() {

        Location l;

        for (int i = 0; i < 20; i++) {
            l = new Location();
            l.setName("Lokacija" + i);
            l.setAddress("Adresa " + i);
            l.setLocality("Mjesto" + i);
            l.setCountry("Država" + i);
            l.setLat(String.valueOf(Math.random() * 100 + 1));
            l.setLng(String.valueOf(Math.random() * 100 + 1));

            ctrlLocation.save(l);

        }
    }

    private void loadEventsTickets() {

        Event e;
        Ticket t;
        List<Location> locations = ctrlLocation.getList(new Location());

        for (int i = 0; i < 100; i++) {
            e = new Event();
            e.setName("Event" + i);
            e.setStartDate(new java.util.Date());
            e.setEndDate(new java.util.Date());
            e.setLocation(locations.get((int) (Math.random() * 19)));

            ctrlEvent.save(e);

            for (int j = 0; j < 3; j++) {
                t = new Ticket();
                t.setName(e.getName() + " ulaznica " + j);
                t.setPrice((double) Math.round(Math.random() * 100 + 1));
                t.setQuantity((int) (Math.random() * 1000 + 1));
                t.setEvent(e);
                e.getTickets().add(t);

                ctrlTicket.save(t);
            }

        }
    }

    private void loadCustomers() {

        Customer c;

        for (int i = 0; i < 100; i++) {
            c = new Customer();
            c.setFirstName("Ime" + i);
            c.setLastName("Prezime" + i);
            c.setAddress("Adresa " + i);
            c.setLocality("Mjesto" + i);
            c.setEmail("email" + i + "@gmail.com");

            ctrlCustomer.save(c);

        }
    }

}
