package org.alex.serve.persistence;

import jakarta.servlet.http.HttpServletRequest;
import org.alex.entity.Employee;
import org.alex.api.Connect;

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

            var preparedStatement = connection.prepareStatement(
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

    public String getTokenFromCookies(HttpServletRequest req){
        var cookies = req.getCookies();

        String token = null;

        for(var cookie : cookies){
            if(cookie.getName().equals("token")){
                token = cookie.getValue();
            }
        }

        return token;
    }

    public String loginByToken(String token) {
        try (var connection = c.getConnect()){

            if(token.isBlank() || token.isEmpty()){
                return null;
            }

            var preparedStatement = connection.prepareStatement(
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

    public void createUser(Employee employee) {
        try (var connection = c.getConnect()){

            var st = connection.prepareStatement(
                    "INSERT INTO users (login, password) VALUES (?, ?)");

            st.setString(1, employee.getLogin());
            st.setString(2, employee.getPass());

            st.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isEmployeeExist(Employee employee){
        try (var connection = c.getConnect()){
            var preparedStatement = connection.prepareStatement(
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
