package org.alex.serve.api;

import java.sql.*;

public class Connect{
    public Connection getConnect(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/votion", "root", "1");
        } catch (SQLException e) {
            throw new RuntimeException("Miss connection");
        }
    }
}
