package org.rides.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity(name = "horse")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HorseEntity {
    @Id
    @UuidGenerator
    private UUID id;
    @Column(name="avg_speed")
    private Double avgSpeed;
    @Column(name="name")
    private String name;
    @OneToMany(
            mappedBy = "horse",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<BetEntity> bet = new ArrayList<>();
    @CreationTimestamp
    private Instant created;
    @UpdateTimestamp
    private Instant updated;

    public HorseEntity(Double avgSpeed, String name) {
        this.avgSpeed = avgSpeed;
        this.name = name;
    }
}
