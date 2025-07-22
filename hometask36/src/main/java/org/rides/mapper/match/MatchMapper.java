package org.rides.mapper.match;

import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.rides.dto.match.MatchDto;
import org.rides.entity.HorseEntity;
import org.rides.entity.MatchEntity;
import org.rides.mapper.horse.HorseMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        componentModel = "spring",
        uses = {HorseMapper.class}
)
@AnnotateWith(value = Service.class)
public interface MatchMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "horses", source = "horse")
    @Mapping(target = "winnerId", source = "winner")
    MatchDto toDto(MatchEntity entity);

    default UUID toHorseId(HorseEntity entity) {
        if(entity == null) {
            return null;
        }
        return entity.getId();
    }
}
