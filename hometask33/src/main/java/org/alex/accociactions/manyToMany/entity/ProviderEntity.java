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

@Entity(name = "provider")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProviderEntity {
    @Id
    @UuidGenerator
    private UUID id;
    @Column(name = "name")
    private String name;
    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "provider_tower",
            joinColumns = @JoinColumn(name = "provider"),
            inverseJoinColumns = @JoinColumn(name = "tower")
    )
    private List<TowerEntity> towers = new ArrayList<>();

    public void addTower(TowerEntity entity){
        towers.add(entity);
        entity.getProviders().add(this);
    }

    public ProviderEntity(String name) {
        this.name = name;
    }

}
