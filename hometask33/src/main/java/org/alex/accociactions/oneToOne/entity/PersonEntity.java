package org.alex.accociactions.oneToOne.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity(name = "person")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonEntity {
    @UuidGenerator
    @Id
    private UUID id;
    @Column(name = "name")
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private HomeEntity home;

    public PersonEntity(String name, HomeEntity home) {
        this.name = name;
        this.home = home;
    }


}
