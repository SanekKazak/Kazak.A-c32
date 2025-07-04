package org.rides.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Table(name = "Bet")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"horse", "player"})
@Component
public class BetEntity {
    @Id
    @UuidGenerator
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    private PlayerEntity player;
    @ManyToOne(fetch = FetchType.LAZY)
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
