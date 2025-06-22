package org.alex.accociactions.oneToOne.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity(name = "home")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HomeEntity {
    @UuidGenerator
    @Id
    private UUID id;
    @Column(name = "address")
    private String address;
    @OneToOne(
            mappedBy = "home"
    )
    private PersonEntity person;

    public HomeEntity(String address) {
        this.address = address;
    }
}
