package org.alex.brain.service;

import org.alex.brain.abstracts.classes.Employee;
import org.alex.brain.employee.Director;

public class EmployeeService {
    public void getCheckResult(Director director, Employee employee){
        for(Employee employeeRunner : director.getEmployeeArray()){
            if(employeeRunner.getName().equals(employee.getName())){
                System.out.println("Congratulations");
                break;
            }
        }
    }
}
