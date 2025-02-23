package org.alex.brain.classes.impl.entities;

import org.alex.brain.abstractClasses.AbstractOrder;
import org.alex.brain.interfaces.contracts.OrderSaver;

public class OrderSaverDbImpl implements OrderSaver {
    public void saveData(AbstractOrder order) {
        System.out.println("Completed save" + order.getType());
    }
}
