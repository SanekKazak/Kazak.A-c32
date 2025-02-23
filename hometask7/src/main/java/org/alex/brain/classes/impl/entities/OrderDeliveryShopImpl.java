package org.alex.brain.classes.impl.entities;

import org.alex.brain.abstractClasses.AbstractOrder;
import org.alex.brain.interfaces.contracts.OrderDelivery;

public class OrderDeliveryShopImpl implements OrderDelivery {

    public void getDeliveryMethod(AbstractOrder order) {
        if (order.getCost() < 100 && order.getCountry().equals("belarus")) {
            System.out.println("Will be in store");
        } else {
            System.out.println("We cannot do this");
        }
        getDeliveryInWindow(order);
    }
}