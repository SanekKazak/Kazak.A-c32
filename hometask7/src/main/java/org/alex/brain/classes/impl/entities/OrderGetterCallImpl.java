package org.alex.brain.classes.impl.entities;

import org.alex.brain.abstractClasses.AbstractOrder;
import org.alex.brain.interfaces.contracts.OrderGetter;

public class OrderGetterCallImpl implements OrderGetter {

    public void getOrder(AbstractOrder order) {
        if (order.getCountry().equals("belarus")) {
            System.out.println("Call is available");
        } else {
            System.out.println("Error, call is not available");
        }

    }
}