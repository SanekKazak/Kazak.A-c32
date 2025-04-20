package org.alex.brain.worker;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        Set<Worker> set = new TreeSet<>((u1, u2) ->  - u1.getPayment() + u2.getPayment());
        set.add(new Worker(123));
        set.add(new Worker(2));
        set.add(new Worker(43));
        set.add(new Worker(7447));
        System.out.println(set);
    }
}
