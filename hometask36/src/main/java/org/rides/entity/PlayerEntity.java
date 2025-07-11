package org.rides.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Player")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString(exclude = "bet")
public class PlayerEntity {
    @Id
    @UuidGenerator
    private UUID id;
    @Column(name = "token")
    private UUID token;
    @OneToMany(
            mappedBy = "player",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<BetEntity> bet = new ArrayList<>();
    @Column(name="login", unique = true)
    private String login;
    @Column(name="password")
    private String password;
    @Column(name="balance")
    private Integer balance = 0;
    @Enumerated(value = EnumType.STRING)
    @ColumnDefault("'USER'")
    @Column(name = "role", nullable = false)
    private RoleType role = RoleType.USER;
    @CreationTimestamp
    private Instant created;
    @UpdateTimestamp
    private Instant updated;


    public PlayerEntity(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public void setBet(List<BetEntity> entity){
        bet.addAll(entity);
        entity.forEach(bet->bet.setPlayer(this));
    }

    public void removeBet(BetEntity entity){
        bet.remove(entity);
        entity.setPlayer(null);
    }

    public enum RoleType{
        ADMIN,
        USER
    }
}
