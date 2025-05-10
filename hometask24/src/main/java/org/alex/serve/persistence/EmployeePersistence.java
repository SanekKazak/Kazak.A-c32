package org.alex.serve.persistence;

import org.alex.api.Connect;
import org.alex.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

            var st1 = connection.prepareStatement(
                    "INSERT INTO tokens (employee_login, token) VALUES (?, null)");

            st1.setString(1, employee.getLogin());


            st.execute();
            st1.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isExist(Employee employee){
        try (var connection = c.getConnect()){
            var preparedStatement = connection.prepareStatement(
                    "select * from employees where login = ?"
            );

            preparedStatement.setString(1, employee.getLogin());

            var set = preparedStatement.executeQuery();

            return set.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> getAll() {
        try (var connection = c.getConnect()){

            var employees = new ArrayList<Employee>();

            var st = connection.prepareStatement(
                    "select * from employees");

            var set = st.executeQuery();

            while(set.next()){
                employees.add(new Employee(set.getString("login")));
            }

            return employees;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
