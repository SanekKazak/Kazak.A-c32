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
import java.util.UUID;


@Entity(name = "bet")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BetEntity {
    @Id
    @UuidGenerator
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "player_id")
    private PlayerEntity player;
    @ManyToOne
    @JoinColumn(name = "horse_id")
    private HorseEntity horse;
    @Column(name = "bet")
    private Integer bet;
    @CreationTimestamp
    private Instant created;
    @UpdateTimestamp
    private Instant updated;

    public BetEntity(PlayerEntity player, HorseEntity horse, Integer bet, Instant created) {
        this.player = player;
        this.horse = horse;
        this.bet = bet;
        this.created = created;
    }

}
