package org.rides.mapper.player;

import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.rides.dto.player.PlayerDto;
import org.rides.entity.PlayerEntity;
import org.springframework.stereotype.Service;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        componentModel = "spring")
@AnnotateWith(value = Service.class)
public interface PlayerMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "login", source = "login")
    @Mapping(target = "balance", ignore = true)
    @Mapping(target = "bet", ignore = true)
    @Mapping(target = "token", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    @Mapping(target = "password", ignore = true)
    PlayerEntity toEntity(PlayerDto dto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "login", source = "login")
    PlayerDto toDto(PlayerEntity entity);
}
