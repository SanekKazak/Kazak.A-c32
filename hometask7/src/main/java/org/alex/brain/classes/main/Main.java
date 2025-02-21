package org.alex.brain.classes.main;

import org.alex.brain.classes.impl.controllers.OrderManagerImpl;
import org.alex.brain.classes.impl.entities.*;
import org.alex.brain.interfaces.controllers.OrderManager;

public class Main {
    public static void main(String[] args) {
        OrderManager manager = new OrderManagerImpl(
                new OrderDeliveryHomeImpl(),
                new OrderStateInfoImpl(),
                new OrderGetterCallImpl(),
                new OrderSaverDbImpl());
        OrderImpl order = new OrderImpl("car", 988, "russia");
        manager.manageOrder(order);
    }
}
