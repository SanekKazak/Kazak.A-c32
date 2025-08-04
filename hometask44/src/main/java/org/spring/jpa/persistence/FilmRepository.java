package org.spring.jpa.persistence;

import org.spring.jpa.entity.FilmEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface FilmRepository extends CrudRepository<FilmEntity, UUID> {
    @Query("SELECT f FROM FilmEntity f")
    List<FilmEntity> getAll();
    List<FilmEntity> getByName(String name);
}
