package org.spring.rest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Table(name = "courses" )
@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @UuidGenerator
    private UUID id;
    @Column(name="name")
    private String name;
    @Column(name="lifecycle")
    private Integer lifecycle;
    @Column(name="cost")
    private BigDecimal cost;
    @Column(name = "is_active")
    private Boolean isActive;

    public Course(String name, Integer lifecycle, BigDecimal cost, Boolean isActive) {
        this.name = name;
        this.lifecycle = lifecycle;
        this.cost = cost;
        this.isActive = isActive;
    }
}
