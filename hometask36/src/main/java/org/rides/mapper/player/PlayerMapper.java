package org.rides.mapper.player;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.rides.dto.PlayerDto;
import org.rides.entity.BetEntity;
import org.rides.entity.PlayerEntity;

import java.util.List;
import java.util.UUID;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        componentModel = "spring")
public interface PlayerMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "login", source = "login")
    @Mapping(target = "balance", source = "balance")
    @Mapping(target = "bet", source = "bets")
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    @Mapping(target = "password", ignore = true)
    PlayerEntity toEntity(PlayerDto dto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "login", source = "login")
    @Mapping(target = "balance", source = "balance")
    @Mapping(target = "bets", source = "bet")
    @Mapping(target = "registrationTime", source = "created")
    PlayerDto toDto(PlayerEntity entity);

    default List<UUID> fromEntityToId(List<BetEntity> entities){
        return entities
                .stream()
                .map(BetEntity::getId)
                .toList();
    }

    default List<BetEntity> fromIdToEntity(List<UUID> uuids){
        return uuids
                .stream()
                .map(this::fromId)
                .toList();
    }

    default BetEntity fromId(UUID id){
        var entity = new BetEntity();
        entity.setId(id);
        return entity;
    }
}
