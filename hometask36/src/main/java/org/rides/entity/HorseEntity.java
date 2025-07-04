package org.rides.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Table(name = "Horse")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"bet"})
@Component
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
            fetch = FetchType.LAZY
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
