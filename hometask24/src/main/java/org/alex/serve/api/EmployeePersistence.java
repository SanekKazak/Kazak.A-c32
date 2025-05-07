package org.alex.serve.api;

import org.alex.entity.Employee;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class EmployeePersistence {

    Connect c;

    public EmployeePersistence() {
        this.c = new Connect();
    }

    public void setToken(Employee employee) {
        try (var connection = c.getConnect()){

            if(!c.isExist(employee)){
                return;
            }

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "update users set token = ? where login = ?"
            );
            preparedStatement.setString(1, UUID.randomUUID().toString());
            preparedStatement.setString(2, employee.getLogin());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getToken(Employee employee) {
        try (var connection = c.getConnect()){

            if(!c.isExist(employee)){
                return null;
            }

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select (token) from users where login = ? and password = ?"
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

            if(token == null || token.isEmpty()){
                return null;
            }

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select * from users where token = ?"
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
}
