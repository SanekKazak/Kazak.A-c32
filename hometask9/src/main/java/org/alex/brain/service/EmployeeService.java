package org.alex.brain.service;

import org.alex.brain.abstracts.classes.Employee;
import org.alex.brain.employee.Director;
import org.alex.brain.enums.Role;

public class EmployeeService {
/*
    В 19 строке это условие:
    ...!employeeRunner.equals(director)...
    используется из-за метода добавления самого директора
    в каждом списке подчинённых у директоров - EmployeeArray
    этот же директор идёт первым, следовательно для того,
    чтобы рекурсия работала нужно пропускать его
    */
    public boolean getCheckResult(Director director, Employee employee){
        for(Employee employeeRunner : director.getEmployeeArray()){
            if(employeeRunner.getName().equals(employee.getName())){
                return true;
            }
            if(employeeRunner.getRole().equals(Role.DIRECTOR) && !employeeRunner.equals(director)){
                return getCheckResult((Director)employeeRunner, employee);
            }
        }
        return false;
    }
}
