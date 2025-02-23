package org.alex.brain.interfaces.contracts;

import org.alex.brain.abstractClasses.AbstractOrder;

public interface OrderSaver {
    void saveData(AbstractOrder order);
}
