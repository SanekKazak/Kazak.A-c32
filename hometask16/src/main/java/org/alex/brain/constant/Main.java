package org.alex.brain.constant;

public class Main {
    public static void main(String[] args) {
        Test<User> test = new Test<>();
        test.testConsumer(
                System.out::println,
                new User("Alex")
        );
        System.out.println(test.testFunction(
                us -> Integer.toString(us.toString().length()),
                new User("John")
        ));
        System.out.println(test.testPredicate(
                user -> user.toString().contains("John"),
                new User("John")
        ));
        System.out.println(test.testSupplier(
                () -> new User("Unknown")
        ));
    }
}
