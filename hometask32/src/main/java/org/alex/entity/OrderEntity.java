package org.alex.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.alex.categories.Goods;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.Instant;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderEntity {
    @Id
    @Column(name = "id")
    @UuidGenerator
    private UUID id;
    @Column(name = "name")
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "goods")
    private Goods goods;
    @Column(name = "created")
    @CreationTimestamp
    private Instant created;
    @Embedded
    private Address address;
    @Column(name = "cost")
    private Long cost;
    @Column(name = "priority")
    private Boolean priority;

    public OrderEntity(String name, Goods goods, Address address, Long cost, Boolean priority) {
        this.name = name;
        this.goods = goods;
        this.address = address;
        this.cost = cost;
        this.priority = priority;
    }
}
