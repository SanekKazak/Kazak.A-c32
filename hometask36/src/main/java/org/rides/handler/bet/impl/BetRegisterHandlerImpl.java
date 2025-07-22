package org.rides.handler.bet.impl;

import lombok.RequiredArgsConstructor;
import org.rides.dto.bet.BetRegistrationDto;
import org.rides.entity.BetEntity;
import org.rides.handler.bet.interfaces.BetRegisterHandler;
import org.rides.mapper.bet.BetRegistrationMapper;
import org.rides.service.bet.interfaces.BetManagerService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BetRegisterHandlerImpl implements BetRegisterHandler {
    private final BetRegistrationMapper mapper;
    private final BetManagerService managerService;

    @Override
    public Boolean register(BetRegistrationDto dto) {
        BetEntity entity = mapper.toEntity(dto);
        return managerService.create(entity);
    }
}
