package org.alex.brain.employee;

import org.alex.brain.abstracts.classes.Employee;
import org.alex.brain.enums.Role;

public class Worker extends Employee {
    public Worker(String name, String surname, int workingExperience) {
        super(name, surname, workingExperience, Role.WORKER);
    }
}
