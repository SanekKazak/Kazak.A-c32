package org.rides.mapper.match;

import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.rides.dto.MatchDto;
import org.rides.entity.BetEntity;
import org.rides.entity.HorseEntity;
import org.rides.entity.MatchEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        componentModel = "spring")
@AnnotateWith(value = Service.class)
public interface MatchMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "isPlayed", source = "isPlayed")
    @Mapping(target = "created", source = "created")
    @Mapping(target = "bet", source = "betsId")
    @Mapping(target = "horse", source = "horsesId")
    @Mapping(target = "winner", source = "winnerId")
    @Mapping(target = "updated", ignore = true)
    MatchEntity toEntity(MatchDto dto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "isPlayed", source = "isPlayed")
    @Mapping(target = "betsId", source = "bet")
    @Mapping(target = "horsesId", source = "horse")
    @Mapping(target = "winnerId", source = "winner")
    @Mapping(target = "created", source = "created")
    MatchDto toDto(MatchEntity entity);

    default List<UUID> fromHorseToUUID(List<HorseEntity> entities){
        return entities.stream()
                .map(HorseEntity::getId)
                .toList();
    }
    default List<HorseEntity> fromUUIDtoHorse(List<UUID> ids){
        return ids.stream()
                .map(this::toHorse)
                .toList();
    }
    default List<UUID> fromBetToUUID(List<BetEntity> entities){
        return entities.stream()
                .map(BetEntity::getId)
                .toList();
    }
    default List<BetEntity> fromUUIDtoBet(List<UUID> ids){
        return ids.stream()
                .map(this::toBet)
                .toList();
    }
    default UUID toHorse(HorseEntity entity){
        return entity.getId();
    }
    default HorseEntity toHorse(UUID id){
        var entity = new HorseEntity();
        entity.setId(id);
        return entity;
    }
    default BetEntity toBet(UUID id){
        var entity = new BetEntity();
        entity.setId(id);
        return entity;
    }
}
