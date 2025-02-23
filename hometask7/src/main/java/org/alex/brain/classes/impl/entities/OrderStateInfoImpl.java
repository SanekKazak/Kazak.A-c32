package org.alex.brain.classes.impl.entities;

import org.alex.brain.abstractClasses.AbstractOrder;
import org.alex.brain.interfaces.contracts.OrderState;

import java.io.PrintStream;

public class OrderStateInfoImpl implements OrderState {

    public void getState(AbstractOrder order) {
        PrintStream var10000 = System.out;
        String var10001 = order.getType();
        var10000.println("Order:" + var10001 + " now ride to " + order.getCountry());
    }
}