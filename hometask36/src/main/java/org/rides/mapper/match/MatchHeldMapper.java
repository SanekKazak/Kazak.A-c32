package org.rides.mapper.match;

import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.rides.dto.match.MatchHeldDto;
import org.rides.entity.MatchEntity;
import org.springframework.stereotype.Service;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        componentModel = "spring")
@AnnotateWith(value = Service.class)
public interface MatchHeldMapper {
    @Mapping(target = "id", source = "matchId")
    @Mapping(target = "horse", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "bet", ignore = true)
    @Mapping(target = "winner", ignore = true)
    @Mapping(target = "updated", ignore = true)
    MatchEntity toEntity(MatchHeldDto dto);
}
