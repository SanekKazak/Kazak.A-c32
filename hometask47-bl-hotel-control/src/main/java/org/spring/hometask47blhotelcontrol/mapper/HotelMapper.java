package org.spring.hometask47blhotelcontrol.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.spring.hometask47blhotelcontrol.dto.HotelDto;
import org.spring.hometask47blhotelcontrol.entity.HotelEntity;

import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.ERROR)
public interface HotelMapper {
    HotelDto toDto(HotelEntity entity);
    HotelEntity toEntity(HotelDto dto);
    List<HotelDto> toDtos(List<HotelEntity> entities);
}
