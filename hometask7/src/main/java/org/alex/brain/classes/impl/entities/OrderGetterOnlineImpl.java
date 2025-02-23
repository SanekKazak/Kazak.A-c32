package org.alex.brain.classes.impl.entities;

import org.alex.brain.abstractClasses.AbstractOrder;
import org.alex.brain.interfaces.contracts.OrderGetter;

public class OrderGetterOnlineImpl implements OrderGetter {
    public void getOrder(AbstractOrder order) {
        if (order.getCost() > 100 && !order.getType().equals("car")) {
            System.out.println("Online connect!");
        } else {
            System.out.println("Try with other order");
        }

    }
}
