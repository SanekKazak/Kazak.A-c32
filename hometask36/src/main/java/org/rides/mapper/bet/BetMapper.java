package org.rides.mapper.bet;

import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.rides.dto.BetDto;
import org.rides.entity.BetEntity;
import org.rides.entity.HorseEntity;
import org.rides.entity.PlayerEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        componentModel = "spring")
@AnnotateWith(value = Service.class)
public interface BetMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "playerId", source = "player")
    @Mapping(target = "horseId", source = "horse")
    @Mapping(target = "bet", source = "bet")
    @Mapping(target = "created", source = "created")
    BetDto toDto(BetEntity entity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "player", source = "playerId")
    @Mapping(target = "horse", source = "horseId")
    @Mapping(target = "bet", source = "bet")
    @Mapping(target = "created", source = "created")
    @Mapping(target = "updated", ignore = true)
    BetEntity toEntity(BetDto dto);

    default UUID fromPlayerToId(PlayerEntity entity){
        return entity.getId();
    }
    default PlayerEntity fromIdToPlayer(UUID id){
        var entity = new PlayerEntity();
        entity.setId(id);
        return entity;
    }
    default UUID fromHorseToid(HorseEntity entity){
        return entity.getId();
    }
    default HorseEntity fromIdToHorse(UUID id){
        var entity = new HorseEntity();
        entity.setId(id);
        return entity;
    }
}
