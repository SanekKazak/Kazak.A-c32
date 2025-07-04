package org.rides.entity;

import jakarta.persistence.*;
import lombok.*;
import org.checkerframework.common.aliasing.qual.Unique;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Player")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"bet"})
@Component
public class PlayerEntity {
    @Id
    @UuidGenerator
    private UUID id;
    @OneToMany(
            mappedBy = "player",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<BetEntity> bet = new ArrayList<>();
    @Column(name="login")
    @Unique
    private String login;
    @Column(name="password")
    private String password;
    @Column(name="balance")
    private Integer balance;
    @CreationTimestamp
    private Instant created;
    @UpdateTimestamp
    private Instant updated;

    public PlayerEntity(@Unique String login, String password, Integer balance) {
        this.login = login;
        this.password = password;
        this.balance = balance;
    }
}
