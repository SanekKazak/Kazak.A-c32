package org.alex.mapper;

import org.alex.dto.OrderDto;
import org.alex.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface OrderMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "goods", source = "goods")
    @Mapping(target = "creationTime", source = "created")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "cost", source = "cost")
    @Mapping(target = "orderPriority", source = "priority")
    OrderDto toDto(OrderEntity entity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "goods", source = "goods")
    @Mapping(target = "created", source = "creationTime")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "cost", source = "cost")
    @Mapping(target = "priority", source = "orderPriority")
    OrderEntity toEntity(OrderDto dto);
}
