package org.rides.handler.horse.impl;

import lombok.RequiredArgsConstructor;
import org.rides.dto.horse.HorseRegistrationDto;
import org.rides.entity.HorseEntity;
import org.rides.handler.horse.interfaces.HorseRegisterHandler;
import org.rides.mapper.horse.HorseRegistrationMapper;
import org.rides.service.horse.interfaces.HorseManagerService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HorseRegisterHandlerImpl implements HorseRegisterHandler {
    private final HorseRegistrationMapper mapper;
    private final HorseManagerService managerService;

    @Override
    public Boolean register(HorseRegistrationDto dto) {
        HorseEntity entity = mapper.toEntity(dto);
        return managerService.create(entity);
    }
}
