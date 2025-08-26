package org.spring.hometask50.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.spring.hometask50.dto.UserDto;
import org.spring.hometask50.entity.UserEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
    UserEntity toEntity(UserDto dto);
}
