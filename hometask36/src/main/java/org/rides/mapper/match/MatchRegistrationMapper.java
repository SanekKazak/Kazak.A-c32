package org.rides.mapper.match;

import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.rides.dto.match.MatchRegistrationDto;
import org.rides.entity.HorseEntity;
import org.rides.entity.MatchEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        componentModel = "spring")
@AnnotateWith(value = Service.class)
public interface MatchRegistrationMapper {
    @Mapping(target = "horse", source = "horsesId")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "bet", ignore = true)
    @Mapping(target = "winner", ignore = true)
    @Mapping(target = "updated", ignore = true)
    MatchEntity toEntity(MatchRegistrationDto dto);

    default List<HorseEntity> fromUUIDtoHorse(List<UUID> ids) {
        return ids.stream()
                .map(this::toHorse)
                .toList();
    }

    default HorseEntity toHorse(UUID id) {
        var entity = new HorseEntity();
        entity.setId(id);
        return entity;
    }
}
