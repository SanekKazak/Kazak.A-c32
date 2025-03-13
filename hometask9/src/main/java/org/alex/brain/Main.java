package org.alex.brain;

import org.alex.brain.employee.Director;
import org.alex.brain.employee.Worker;
import org.alex.brain.service.EmployeeService;

public class Main {
    public static void main(String[] args) {
        Director director0 = new Director("Alex", "Braun", 2);
        Director director1 = new Director("Ale", "Brau", 10);
        Director director2 = new Director("Lex", "Bra", 24);
        Director director3 = new Director("Alexo", "Br", 15);
        Worker worker1 = new Worker("Domenic", "Elis", 3);
        Worker worker2 = new Worker("Donny", "Frun", 1);
        Worker worker3 = new Worker("Tom", "Loya", 22);
        Worker worker4 = new Worker("Pad", "Noi", 7);
        director0.add(worker1);
        director1.add(worker2);
        director2.add(worker3);
        director3.add(worker4);
        director0.add(director1);
        director1.add(director2);
        director2.add(director3);
        EmployeeService employeeService = new EmployeeService();
        System.out.println(employeeService.getCheckResult(director0, director3));
        System.out.println(employeeService.getCheckResult(director0, worker4));
        System.out.println(employeeService.getCheckResult(director1, director0));


    }
}
