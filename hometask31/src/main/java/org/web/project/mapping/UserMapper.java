package org.web.project.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.web.project.dto.AnswerDto;
import org.web.project.entity.AnswerEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserMapper {
    AnswerDto toDto(AnswerEntity entity);
    AnswerEntity toEntity(AnswerDto dto);
}
