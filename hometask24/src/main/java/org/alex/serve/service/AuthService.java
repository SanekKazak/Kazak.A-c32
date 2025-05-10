package org.alex.serve.service;

import org.alex.api.Connect;
import org.alex.entity.Employee;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class AuthService {
    Connect c;

    public AuthService() {
        this.c = new Connect();
    }

    public String getToken(Employee employee) {
        try (var connection = c.getConnect()){

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select (token) from employees where login = ? and password = ?"
            );

            preparedStatement.setString(1, employee.getLogin());
            preparedStatement.setString(2, employee.getPass());

            var set = preparedStatement.executeQuery();

            if(set.next()){
                return set.getString("token");
            }else{
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String loginByToken(String token) {
        try (var connection = c.getConnect()){

            if(token.isBlank() || token.isEmpty()){
                return null;
            }

            var preparedStatement = connection.prepareStatement(
                    "select * from employees where token = ?"
            );
            preparedStatement.setString(1, token);

            var user = preparedStatement.executeQuery();

            if(user.next()){
                return user.getString("login");
            }

            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setToken(Employee employee) {
        try (var connection = c.getConnect()){

            var preparedStatement = connection.prepareStatement(
                    "update employees set token = ? where login = ?"
            );
            preparedStatement.setString(1, UUID.randomUUID().toString());
            preparedStatement.setString(2, employee.getLogin());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
