package org.rides.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

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
public class HorseEntity {
    @Id
    @UuidGenerator
    private UUID id;
    @Column(name = "avg_speed")
    private Double avgSpeed;
    @Column(name = "name")
    private String name;
    @OneToMany(
            mappedBy = "winner",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private List<MatchEntity> award = new ArrayList<>();
    @OneToMany(
            mappedBy = "horse",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private List<BetEntity> bet = new ArrayList<>();
    @ManyToMany(
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY
    )
    private List<MatchEntity> match = new ArrayList<>();
    @CreationTimestamp
    private Instant created;
    @UpdateTimestamp
    private Instant updated;

    public HorseEntity(Double avgSpeed, String name) {
        this.avgSpeed = avgSpeed;
        this.name = name;
    }

    public HorseEntity(UUID id, Double avgSpeed, String name) {
        this.id = id;
        this.avgSpeed = avgSpeed;
        this.name = name;
    }

    public void setAward(MatchEntity entity) {
        award.add(entity);
        entity.setWinner(this);
    }

    public void setAward(List<MatchEntity> entity) {
        award.addAll(entity);
    }

    public void setBet(BetEntity entity) {
        bet.add(entity);
        entity.setHorse(this);
    }

    public void setBet(List<BetEntity> entity) {
        bet.addAll(entity);
    }

    public void setMatch(MatchEntity entity) {
        match.add(entity);
    }

    public void setMatch(List<MatchEntity> entity) {
        match.addAll(entity);
    }
}
