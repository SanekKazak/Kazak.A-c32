package org.alex.brain;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Set<Order> set = new HashSet<>();
        set.add(new Order(1, true, "alex"));
        set.add(new Order(2, true, "Jhoe"));
        set.add(new Order(3, false, "Noah"));
        set.add(new Order(2, false, "Brain"));
        set.add(new Order(1, true, "alex"));
        System.out.println(set);
    }
}
