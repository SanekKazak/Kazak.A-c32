package org.rides.mapper.bet;

import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.rides.dto.bet.BetRegistrationDto;
import org.rides.entity.BetEntity;
import org.rides.entity.HorseEntity;
import org.rides.entity.MatchEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        componentModel = "spring")
@AnnotateWith(value = Service.class)
public interface BetRegistrationMapper {
    @Mapping(target = "horse", source = "horseId")
    @Mapping(target = "bet", source = "bet")
    @Mapping(target = "match", source = "matchId")
    @Mapping(target = "player", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "result", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    BetEntity toEntity(BetRegistrationDto dto);

    default MatchEntity fromIdToMatch(UUID id) {
        var entity = new MatchEntity();
        entity.setId(id);
        return entity;
    }

    default HorseEntity fromIdToHorse(UUID id) {
        var entity = new HorseEntity();
        entity.setId(id);
        return entity;
    }
}
