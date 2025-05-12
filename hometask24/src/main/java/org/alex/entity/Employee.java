package org.alex.entity;


import lombok.Getter;
import org.alex.serve.persistence.EmployeePersistence;

@Getter
public class Employee extends Entity<Employee> {
    private String login;
    private String pass;

    public Employee(String login, String pass) {
        this.login = login;
        this.pass = pass;
        persistence = new EmployeePersistence();
    }

    public Employee(String login) {
        this.login = login;
        persistence = new EmployeePersistence();
    }

    @Override
    public String toString() {
        return "Employee:" + login;
    }
}
