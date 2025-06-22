package org.alex.accociactions.oneToMany.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "wardrobe")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WardrobeEntity {
    @Id
    @UuidGenerator
    private UUID id;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ClothEntity> clothes = new ArrayList<>();

    public WardrobeEntity(String name) {
        this.name = name;
    }

    public void addCloth(ClothEntity entity){
        clothes.add(entity);
        entity.setWardrobe(this);
    }
}
