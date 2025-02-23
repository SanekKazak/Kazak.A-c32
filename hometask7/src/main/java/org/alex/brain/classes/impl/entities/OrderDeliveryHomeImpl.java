package org.alex.brain.classes.impl.entities;

import org.alex.brain.abstractClasses.AbstractOrder;
import org.alex.brain.interfaces.contracts.OrderDelivery;

public class OrderDeliveryHomeImpl implements OrderDelivery {

    public void getDeliveryMethod(AbstractOrder order) {
        if (order.getCost() > 100 && !order.getCountry().equals("belarus")) {
            System.out.println("Will be home");
        } else {
            System.out.println("Cannot do this");
        }

    }
}
