package org.alex.api;

import org.alex.entity.Employee;

import java.sql.*;

public class Connect{

    public Connection getConnect(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/Votion", "root", "1");
        } catch (SQLException e) {
            throw new RuntimeException("Miss connection");
        }
    }
}
