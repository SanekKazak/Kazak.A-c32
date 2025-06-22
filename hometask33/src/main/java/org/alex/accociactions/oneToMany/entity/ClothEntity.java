package org.alex.accociactions.oneToMany.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity(name = "cloth")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClothEntity {
    @Id
    @UuidGenerator
    private UUID id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "wardrobe_id")
    private WardrobeEntity wardrobe;

    public ClothEntity(String name) {
        this.name = name;
    }
}
