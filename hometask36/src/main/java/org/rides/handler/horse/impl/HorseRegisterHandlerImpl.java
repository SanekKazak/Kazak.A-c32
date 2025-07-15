package org.rides.handler.horse.impl;

import lombok.RequiredArgsConstructor;
import org.rides.dto.HorseDto;
import org.rides.entity.HorseEntity;
import org.rides.handler.horse.interfaces.HorseRegisterHandler;
import org.rides.mapper.horse.HorseMapper;
import org.rides.service.horse.interfaces.HorseManagerService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HorseRegisterHandlerImpl implements HorseRegisterHandler {
    private final HorseMapper mapper;
    private final HorseManagerService managerService;
    @Override
    public Boolean register(HorseDto dto) {
        HorseEntity entity = mapper.toEntity(dto);
        return managerService.create(entity);
    }
}
