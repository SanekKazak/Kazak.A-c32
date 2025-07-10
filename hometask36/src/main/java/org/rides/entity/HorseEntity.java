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
    @Column(name="avg_speed")
    private Double avgSpeed;
    @Column(name="name")
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
            cascade = {CascadeType.MERGE, CascadeType.PERSIST}
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

    public void setAward(List<MatchEntity> entity){
        award.addAll(entity);
        entity.forEach(bet->bet.setWinner(this));
    }

    public void removeAward(MatchEntity entity){
        award.remove(entity);
        entity.setWinner(null);
    }

    public void setBet(List<BetEntity> entity){
        bet.addAll(entity);
        entity.forEach(bet -> bet.setHorse(this));
    }

    public void removeBet(BetEntity entity){
        bet.remove(entity);
        entity.setHorse(null);
    }

    public void setMatch(List<MatchEntity> entity){
        match.addAll(entity);
        entity.forEach(horse->horse.getHorse().add(this));
    }

    public void removeMatch(MatchEntity entity){
        match.remove(entity);
        entity.getHorse().remove(this);
    }
}
