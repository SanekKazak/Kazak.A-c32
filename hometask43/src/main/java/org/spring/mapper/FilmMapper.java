package org.spring.mapper;

import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.spring.entity.FilmEntity;
import org.spring.entity.FilmRegisterDto;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.ERROR)
public interface FilmMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    FilmEntity toEntity(FilmRegisterDto filmRegisterDto);
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    FilmRegisterDto toDto(FilmEntity filmEntity);
}
