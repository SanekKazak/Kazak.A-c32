package org.spring.hometask47blhotelcontrol.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name="hotels")
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class HotelEntity {
    @Id
    @UuidGenerator
    private UUID id;
    @Column(name="place_count")
    private Integer placeCount;
    @Column(name="name")
    private String name;
}

