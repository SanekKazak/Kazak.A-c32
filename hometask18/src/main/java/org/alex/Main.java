package org.alex;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static List<Employee> employees = List.of(
            new Employee(Role.MANAGER, 85000),
            new Employee(Role.ADMIN, 62000),
            new Employee(Role.WORKER, 40000),
            new Employee(Role.ADMIN, 57000),
            new Employee(Role.WORKER, 39000),
            new Employee(Role.MANAGER, 91000),
            new Employee(Role.WORKER, 45000),
            new Employee(Role.ADMIN, 60000),
            new Employee(Role.MANAGER, 99000),
            new Employee(Role.WORKER, 37000)
    );
    /*
    Есть список сотрудников компании.
    Каждый сотрудник обладает следующими полями (профессия - enum, величина зп).
    При помощи стрима и методов группировки необходимо узнать
     */
    public static void main(String[] args) {

        //1) Среднюю зп по профессиям
        var averagingMap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getRole, Collectors.averagingInt(Employee::getPayment)));
        System.out.println(averagingMap);

        //2) Сколько работников относится к каждой из профессий
        var workerMap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getRole, Collectors.counting()));
        System.out.println(workerMap);

        //3) Сколько компания тратит денег на зп каждой профессии
        var paymentMap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getRole, Collectors.summingInt(Employee::getPayment)));
        System.out.println(paymentMap);

    }
}
