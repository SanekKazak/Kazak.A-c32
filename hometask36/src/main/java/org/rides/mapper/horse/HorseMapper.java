package org.rides.mapper.horse;

import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.rides.dto.HorseDto;
import org.rides.entity.HorseEntity;
import org.rides.entity.MatchEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        componentModel = "spring")
@AnnotateWith(value = Service.class)
public interface HorseMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "avgSpeed", source = "avgSpeed")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "match", source = "matchesId")
    @Mapping(target = "award", source = "awardsId")
    @Mapping(target = "bet", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    HorseEntity toEntity(HorseDto dto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "avgSpeed", source = "avgSpeed")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "matchesId", source = "match")
    @Mapping(target = "awardsId", source = "award")
    HorseDto toDto(HorseEntity entity);

    default List<UUID> fromMatchesToId(List<MatchEntity> entities){
        return entities.stream()
                .map(MatchEntity::getId)
                .toList();
    }
    default List<MatchEntity> fromIdToMatch(List<UUID> ids){
        return ids.stream()
                .map(this::fromIdToMatch)
                .toList();
    }
    default MatchEntity fromIdToMatch(UUID id){
        var entity = new MatchEntity();
        entity.setId(id);
        return entity;
    }
}
