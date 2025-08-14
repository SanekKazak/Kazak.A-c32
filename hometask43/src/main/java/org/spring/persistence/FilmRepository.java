package org.spring.persistence;

import org.spring.entity.FilmEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.UUID;

public interface FilmRepository extends CrudRepository<FilmEntity, UUID> {
    @Query("SELECT f FROM FilmEntity f")
    List<FilmEntity> getAll();
    FilmEntity getById(UUID id);
}
