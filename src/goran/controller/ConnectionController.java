/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Goran
 */
public abstract class ConnectionController {
    
    protected Connection connection;
    protected PreparedStatement ps;
    protected ResultSet rs;
    
    public ConnectionController () {
        
        connection = SQLConnection.getInstance().getConnection();
        
    }
}