package org.alex;

import org.alex.categories.Goods;
import org.alex.dto.OrderDto;
import org.alex.entity.Address;
import org.alex.sevice.OrderService;

public class Main {
    public static void main(String[] args) {
        var order = new OrderDto("L2", Goods.bread, new Address("Moskovsy", "Vitebsk"), 24L, true);
        OrderService service = new OrderService();
        service.create(order);
    }
}
