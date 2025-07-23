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
import java.util.*;

@Table(name = "Match")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MatchEntity {
    @Id
    @UuidGenerator
    private UUID id;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "winner_id")
    private HorseEntity winner;
    @OneToMany(
            mappedBy = "match",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}
    )
    private List<BetEntity> bet = new ArrayList<>();
    @ManyToMany(
            mappedBy = "match",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    private Set<HorseEntity> horse = new HashSet<>();
    @CreationTimestamp
    private Instant created;
    @UpdateTimestamp
    private Instant updated;

    public void setBet(BetEntity entity) {
        bet.add(entity);
        entity.setMatch(this);
    }

    public void setBet(List<BetEntity> entity) {
        bet.addAll(entity);
    }

    public void setHorse(Set<HorseEntity> horse) {
        this.horse = horse;
    }

    public void setHorse(List<HorseEntity> horse) {
        this.horse = new HashSet<>(horse);
    }

    public List<HorseEntity> getHorse() {
        return horse.stream().toList();
    }
}
