package org.alex.brain.interfaces.contracts;

import org.alex.brain.abstractClasses.AbstractOrder;

public interface OrderDelivery {
    void getDeliveryMethod(AbstractOrder order);
    default void getDeliveryInWindow(AbstractOrder order){
        System.out.println("your order in window!");
    }
}
