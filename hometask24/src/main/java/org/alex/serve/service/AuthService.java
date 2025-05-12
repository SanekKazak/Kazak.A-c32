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
                    "select (token) from tokens where employee_login = ?"
            );

            preparedStatement.setString(1, employee.getLogin());

            var set = preparedStatement.executeQuery();

            if(set.next()){
                return set.getString("token");
            }

            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String loginByToken(String token) {
        try (var connection = c.getConnect()){

            if(token==null || token.isEmpty()){
                return null;
            }

            var preparedStatement = connection.prepareStatement(
                    "select employee_login from tokens where token = ?"
            );

            preparedStatement.setString(1, token);

            var set = preparedStatement.executeQuery();

            if(set.next()){
                return set.getString("employee_login");
            }

            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateToken(Employee employee) {
        try (var connection = c.getConnect()){

            var preparedStatement = connection.prepareStatement(
                    "update tokens set token = ? where employee_login = ?"
            );
            preparedStatement.setString(1, UUID.randomUUID().toString());
            preparedStatement.setString(2, employee.getLogin());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
