package org.alex.serve.persistence;

import jakarta.servlet.http.HttpServletRequest;
import org.alex.entity.Employee;
import org.alex.api.Connect;
import org.alex.entity.Entity;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class EmployeePersistence implements Persistence<Employee>{

    Connect c;

    public EmployeePersistence() {
        this.c = new Connect();
    }

    @Override
    public void create(Employee employee) {
        try (var connection = c.getConnect()){

            var st = connection.prepareStatement(
                    "INSERT INTO employees (login, password) VALUES (?, ?)");

            st.setString(1, employee.getLogin());
            st.setString(2, employee.getPass());

            st.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isExist(Employee employee){
        try (var connection = c.getConnect()){
            var preparedStatement = connection.prepareStatement(
                    "select * from employees where login = ?"
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
