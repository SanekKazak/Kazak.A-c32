package org.rides.entity;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
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

@Entity(name = "player")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlayerEntity {
    @Id
    @UuidGenerator
    private UUID id;
    @OneToMany(
            mappedBy = "player",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<BetEntity> bet = new ArrayList<>();
    @Column(name="login")
    private String login;
    @Column(name="password")
    private String password;
    @Column(name="balance")
    private Integer balance;
    @CreationTimestamp
    private Instant created;
    @UpdateTimestamp
    private Instant updated;

    public PlayerEntity(String login, String password, Integer balance) {
        this.login = login;
        this.password = password;
        this.balance = balance;
    }
}
