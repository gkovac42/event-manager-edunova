/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.controller;

import goran.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Goran
 */
public class UserController extends ConnectionController {

    public List<User> getUsers() {

        List<User> users = new ArrayList<>();

        try {

            ps = connection.prepareStatement("select * from korisnik");
            rs = ps.executeQuery();
            User user;

            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("ime"));
                user.setLastName(rs.getString("prezime"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("adresa"));
                user.setLocality(rs.getString("mjesto"));
                users.add(user);
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public void addUser(User user) {

        try {

            ps = connection.prepareStatement("insert into korisnik (ime,prezime,email,adresa,mjesto) values (?,?,?,?,?)");
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getAddress());
            ps.setString(5, user.getLocality());
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editUser(User user) {

        try {

            ps = connection.prepareStatement("update korisnik set ime=?, prezime=?, email=?, adresa=?, mjesto=? where id=?");
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getAddress());
            ps.setString(5, user.getLocality());
            ps.setInt(6, user.getId());
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeUser(User user) {
        try {

            ps = connection.prepareStatement("delete from korisnik where id=?");
            ps.setInt(1, user.getId());
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> findUsers(String s) {

        List<User> users = new ArrayList<>();

        try {

            ps = connection.prepareStatement("select * from korisnik where ime like '%" + s + "%' or "
                    + "prezime like '%" + s + "%' or "
                    + "email like '%" + s + "%' or "
                    + "adresa like '%" + s + "%' or "
                    + "mjesto like '%" + s + "%'");
            rs = ps.executeQuery();
            User user;

            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("ime"));
                user.setLastName(rs.getString("prezime"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("adresa"));
                user.setLocality(rs.getString("mjesto"));
                users.add(user);
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}
