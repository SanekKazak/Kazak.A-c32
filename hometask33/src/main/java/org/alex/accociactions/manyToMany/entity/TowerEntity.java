package org.alex.accociactions.manyToMany.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "ethernet_tower")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TowerEntity {
    @Id
    @UuidGenerator
    private UUID id;
    @Column(name = "name")
    private String name;
    @ManyToMany(
            mappedBy = "towers",
            fetch = FetchType.EAGER
    )
    private List<ProviderEntity> providers = new ArrayList<>();

    public TowerEntity(String name) {
        this.name = name;
    }

}

