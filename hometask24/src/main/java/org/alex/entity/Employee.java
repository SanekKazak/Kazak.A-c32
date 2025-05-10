package org.alex.entity;


import lombok.*;
import org.alex.serve.persistence.EmployeePersistence;
import org.alex.serve.persistence.Persistence;
import org.alex.serve.persistence.PlacePersistence;

@AllArgsConstructor @NoArgsConstructor
@Getter
public class Employee extends Entity<Employee> {
    private String name;
    private String login;
    private String pass;

    public Employee(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public Employee(String login) {
        this.login = login;
    }


}
