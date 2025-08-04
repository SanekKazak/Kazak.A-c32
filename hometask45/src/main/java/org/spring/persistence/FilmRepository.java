package org.spring.persistence;

import jakarta.persistence.criteria.Predicate;
import org.spring.dto.FilterDto;
import org.spring.entity.FilmEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface FilmRepository extends JpaRepository<FilmEntity, UUID>, JpaSpecificationExecutor<FilmEntity> {
}
