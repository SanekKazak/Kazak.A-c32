package org.alex.brain.classes.impl.controllers;

import org.alex.brain.abstractClasses.AbstractOrder;
import org.alex.brain.interfaces.contracts.OrderDelivery;
import org.alex.brain.interfaces.contracts.OrderGetter;
import org.alex.brain.interfaces.contracts.OrderSaver;
import org.alex.brain.interfaces.contracts.OrderState;
import org.alex.brain.interfaces.controllers.OrderManager;

public class OrderManagerImpl implements OrderManager {
    private OrderDelivery delivery;
    private OrderState state;
    private OrderGetter getter;
    private OrderSaver saver;

    public OrderManagerImpl(OrderDelivery delivery, OrderState state, OrderGetter getter, OrderSaver saver) {
        this.delivery = delivery;
        this.state = state;
        this.getter = getter;
        this.saver = saver;
    }

    public void manageOrder(AbstractOrder order) {
        this.delivery.getDeliveryMethod(order);
        this.state.getState(order);
        this.getter.getOrder(order);
        this.saver.saveData(order);
    }
}