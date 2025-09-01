package org.spring.hometask52.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.spring.hometask52.dto.UserDto;
import org.spring.hometask52.entity.UserEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserEntity toEntity(UserDto dto);
}
