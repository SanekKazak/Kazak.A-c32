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

@Table(name = "Match")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class MatchEntity {
    @Id
    @UuidGenerator
    private UUID id;
    @Column(name = "is_played")
    private Boolean isPlayed;
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
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY
    )
    private List<HorseEntity> horse = new ArrayList<>();
    @CreationTimestamp
    private Instant created;
    @UpdateTimestamp
    private Instant updated;

    public void setBet(List<BetEntity> entity){
        bet.addAll(entity);
        entity.forEach(bet->bet.setMatch(this));
    }

    public void removeBet(BetEntity entity){
        bet.remove(entity);
        entity.setMatch(null);
    }
}
