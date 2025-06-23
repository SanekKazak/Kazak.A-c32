package org.alex.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "car")
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@ToString
public class CarEntity {
    @Id
    @UuidGenerator
    private UUID id;
    @Enumerated(value = EnumType.STRING)
    private Brand brand;
    @Column(name = "cost")
    private Integer cost;
    @Column(name = "mileage")
    private Integer mileage;
    @Column(name = "released")
    private LocalDate released;

    public CarEntity(Brand brand, Integer cost, Integer mileage, LocalDate released) {
        this.brand = brand;
        this.cost = cost;
        this.mileage = mileage;
        this.released = released;
    }
}
