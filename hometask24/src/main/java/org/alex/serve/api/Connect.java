package org.alex.serve.api;

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

    public boolean isExist(Employee employee){
        try (var connection = getConnect()){
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select * from users where login = ?"
            );

            preparedStatement.setString(1, employee.getLogin());

            var set = preparedStatement.executeQuery();

            if(set.next()){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
