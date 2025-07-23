package org.rides.mapper.bet;

import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.rides.dto.bet.BetDto;
import org.rides.entity.BetEntity;
import org.rides.entity.HorseEntity;
import org.rides.entity.MatchEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        componentModel = "spring")
@AnnotateWith(value = Service.class)
public interface BetMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "horseId", source = "horse")
    @Mapping(target = "bet", source = "bet")
    @Mapping(target = "matchId", source = "match")
    @Mapping(target = "result", source = "result")
    BetDto toDto(BetEntity entity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "horse", source = "horseId")
    @Mapping(target = "bet", source = "bet")
    @Mapping(target = "match", source = "matchId")
    @Mapping(target = "result", source = "result")
    @Mapping(target = "player", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    BetEntity toEntity(BetDto dto);

    default UUID fromMatchToId(MatchEntity entity) {
        return entity.getId();
    }

    default MatchEntity fromIdToMatch(UUID id) {
        var entity = new MatchEntity();
        entity.setId(id);
        return entity;
    }

    default UUID fromHorseToId(HorseEntity entity) {
        return entity.getId();
    }

    default HorseEntity fromIdToHorse(UUID id) {
        var entity = new HorseEntity();
        entity.setId(id);
        return entity;
    }
}
