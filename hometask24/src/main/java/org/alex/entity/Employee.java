package org.alex.entity;


import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Getter
public class Employee {
    private int id;
    private String name;
    private String login;
    private String pass;

    public Employee(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }
}
