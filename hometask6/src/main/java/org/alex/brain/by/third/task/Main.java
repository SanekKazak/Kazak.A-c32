package org.alex.brain.by.third.task;

import org.alex.brain.by.third.task.main.object.Student;
import org.alex.brain.by.third.task.serrvice.ServiceStudent;

public class Main {
    public static void main(String[] args) {
        ServiceStudent serviceStudent = new ServiceStudent();
        serviceStudent.StudentAdder(new Student("Alex", "it-12", 15));
        serviceStudent.StudentAdder(new Student("Grigory", "A-36", 43));
        serviceStudent.StudentAdder(new Student("Pavel", "Ibm-5", 37));
        serviceStudent.StudentAdder(new Student("Pablo", "U-21", 16));
        serviceStudent.StudentAdder(new Student("Serge", "it-12", 23));
        System.out.println(serviceStudent.countGroup("it-12"));
    }
}
