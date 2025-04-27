package org.alex.brain.employee;

import lombok.Getter;
import lombok.Setter;
import org.alex.brain.abstracts.classes.Employee;
import org.alex.brain.enums.Role;

import java.util.Arrays;

@Getter
@Setter
public class Director extends Employee {
    private Employee[] employeeArray = new Employee[0];

    public Director(String name, String surname, int workingExperience) {
        super(name, surname, workingExperience, Role.DIRECTOR);
    }

    public void add(Employee employee){
        if(employee instanceof Director director) {
            Employee[] result = new Employee[this.employeeArray.length + director.getEmployeeArray().length];
            System.arraycopy(director.getEmployeeArray(), 0, result, 0, director.getEmployeeArray().length);
            System.arraycopy(this.employeeArray, 0, result, director.getEmployeeArray().length, employeeArray.length);
            result = Arrays.copyOf(result, result.length + 1);
            result[result.length-1] = employee;
            this.employeeArray = result;
        }else{
            this.employeeArray = Arrays.copyOf(this.employeeArray, this.employeeArray.length + 1);
            this.employeeArray[this.employeeArray.length-1] = employee;
        }
    }

    @Override
    public String toString() {
        return "Director{" +
                "employeeArray=" + Arrays.toString(employeeArray) +
                " name=" + getName()+
                " surname=" + getSurname()+
                " role=" + getRole()+
                '}';
    }
}
