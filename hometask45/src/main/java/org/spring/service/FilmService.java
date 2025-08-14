package org.spring.service;

import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.spring.dto.FilterDto;
import org.spring.entity.FilmEntity;
import org.spring.persistence.FilmRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmService {
    private final FilmRepository repo;

    public List<FilmEntity> findAllByFilter(FilterDto dto){
        return repo.findAll(createSpec(dto));
    }

    private Specification<FilmEntity> createSpec(FilterDto dto){
        return(root, query, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
            if(dto.getContains()!=null && !dto.getContains().isBlank()){
                list.add(criteriaBuilder.equal(root.get("name"), dto.getContains()));
            }
            if (dto.getTo() != null) {
                list.add(criteriaBuilder.greaterThan(root.get("size"), dto.getFrom()));
            }
            if (dto.getFrom() != null) {
                list.add(criteriaBuilder.lessThan(root.get("size"), dto.getTo()));
            }
            return criteriaBuilder.and(list.toArray(new Predicate[]{}));
        };
    }
}
