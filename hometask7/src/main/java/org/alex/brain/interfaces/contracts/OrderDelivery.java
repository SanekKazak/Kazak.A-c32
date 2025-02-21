package org.alex.brain.interfaces.contracts;

import org.alex.brain.abstractClasses.AbstractOrder;

public interface OrderDelivery {
    void getDeliveryMethod(AbstractOrder order);
}
