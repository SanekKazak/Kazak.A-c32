package org.alex.brain.constant;

public class Main {
    public static void main(String[] args) {
        Service<User> service = new Service<>();
        service.serviceConsumer(
                System.out::println,
                new User("Alex")
        );
        System.out.println(service.serviceFunction(
                us -> Integer.toString(us.toString().length()),
                new User("John")
        ));
        System.out.println(service.servicePredicate(
                user -> user.toString().contains("John"),
                new User("John")
        ));
        System.out.println(service.serviceSupplier(
                () -> new User("Unknown")
        ));
    }
}
