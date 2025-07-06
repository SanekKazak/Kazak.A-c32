package org.alex.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.alex.categories.Goods;
import org.alex.entity.Address;

import java.time.Instant;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {
    private UUID id;
    private String name;
    private Goods goods;
    private Instant creationTime;
    private Address address;
    private Long cost;
    private Boolean orderPriority;

    public OrderDto(String name, Goods goods, Address address, Long cost, Boolean orderPriority) {
        this.name = name;
        this.goods = goods;
        this.address = address;
        this.cost = cost;
        this.orderPriority = orderPriority;
    }
}
