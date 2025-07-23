package org.rides.mapper.horse;

import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.rides.dto.horse.HorseDto;
import org.rides.entity.HorseEntity;
import org.springframework.stereotype.Service;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        componentModel = "spring")
@AnnotateWith(value = Service.class)
public interface HorseMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "avgSpeed", source = "avgSpeed")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "match", ignore = true)
    @Mapping(target = "award", ignore = true)
    @Mapping(target = "bet", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    HorseEntity toEntity(HorseDto dto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "avgSpeed", source = "avgSpeed")
    @Mapping(target = "name", source = "name")
    HorseDto toDto(HorseEntity entity);
}
