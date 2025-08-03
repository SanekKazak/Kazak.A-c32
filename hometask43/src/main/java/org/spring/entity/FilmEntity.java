package org.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Entity
@Table(name = "film")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilmEntity {
    @Id
    private UUID id;
    @Column(name = "name")
    private String name;
}
