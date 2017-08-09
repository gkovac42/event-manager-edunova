/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.controller;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Goran
 */
public class SQLConnection {

    private static SQLConnection instance;
    private Connection connection;

    public SQLConnection() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/eventi?useUnicode=true&characterEncoding=UTF-8", "root", "");
            System.out.println("connected");
        } catch (Exception e) {

            System.err.println("sql connection failed");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public static SQLConnection getInstance() {
        if (instance == null) {
            instance = new SQLConnection();
        }
        return instance;
    }

}