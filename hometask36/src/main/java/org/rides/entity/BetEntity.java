package org.rides.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.Instant;
import java.util.UUID;

@Table(name = "Bet")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"horse", "player", "match"})
public class BetEntity {
    @Id
    @UuidGenerator
    private UUID id;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "player_id")
    private PlayerEntity player;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "horse_id")
    private HorseEntity horse;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "match_id")
    private MatchEntity match;
    @Column(name = "bet")
    private Integer bet;
    @Enumerated(value = EnumType.STRING)
    @ColumnDefault("'PROCESS'")
    private ResultType result;
    @CreationTimestamp
    private Instant created;
    @UpdateTimestamp
    private Instant updated;

    public BetEntity(PlayerEntity player, HorseEntity horse, MatchEntity match, Instant created, Integer bet, ResultType result) {
        this.player = player;
        this.horse = horse;
        this.match = match;
        this.bet = bet;
        this.created = created;
        this.result = result;
    }

    public enum ResultType{
        WIN,
        LOSE,
        PROCESS
    }

}
