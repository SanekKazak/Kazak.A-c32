package org.alex.sevice;

import org.alex.dto.OrderDto;
import org.alex.mapper.OrderMapperImpl;
import org.alex.persistence.OrderPersistence;

public class OrderService {
    private final OrderPersistence repository = new OrderPersistence();
    private final OrderMapperImpl mapper = new OrderMapperImpl();

    public void create(OrderDto dto){
        if(dto.getAddress()!=null){
            System.out.println("address not null");
        }

        var entity = mapper.toEntity(dto);

        repository.create(entity);
    }
}
