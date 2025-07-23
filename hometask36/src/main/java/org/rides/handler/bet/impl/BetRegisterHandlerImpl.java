package org.rides.handler.bet.impl;

import lombok.RequiredArgsConstructor;
import org.rides.dto.bet.BetRegistrationDto;
import org.rides.entity.BetEntity;
import org.rides.entity.PlayerEntity;
import org.rides.handler.bet.interfaces.BetRegisterHandler;
import org.rides.mapper.bet.BetRegistrationMapper;
import org.rides.service.bet.interfaces.BetManagerService;
import org.rides.service.player.interfaces.PlayerAuthService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BetRegisterHandlerImpl implements BetRegisterHandler {
    private final BetRegistrationMapper mapper;
    private final BetManagerService managerService;
    private final PlayerAuthService authService;

    @Override
    public Boolean register(BetRegistrationDto dto, UUID token) {
        BetEntity entity = mapper.toEntity(dto);
        PlayerEntity byToken = authService.findByToken(token);
        entity.setPlayer(byToken);
        return managerService.create(entity);
    }
}
