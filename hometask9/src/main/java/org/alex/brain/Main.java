package org.alex.brain;

import org.alex.brain.employee.Director;
import org.alex.brain.employee.Worker;
import org.alex.brain.enums.Role;
import org.alex.brain.service.EmployeeService;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Director director = new Director("Alex", "Braun", 2);
        Director director1 = new Director("Alexo", "Brauno", 20);
        Worker worker1 = new Worker("Domenic", "Elis", 3);
        Worker worker2 = new Worker("Donny", "Frun", 1);
        Worker worker3 = new Worker("Tom", "Loya", 22);
        Worker worker4 = new Worker("Pad", "Noi", 7);
        System.out.println(worker2);
        System.out.println(worker3);
        System.out.println(worker4);
        System.out.println(director.toString());
        director.add(worker1);
        System.out.println(director.toString());
        director1.add(director);
        System.out.println(director1.toString());
        EmployeeService employeeService = new EmployeeService();
        employeeService.getCheckResult(director1, worker1);
        employeeService.getCheckResult(director1, worker2);
        employeeService.getCheckResult(director1, director);
    }
}
