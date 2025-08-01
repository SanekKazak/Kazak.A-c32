package org.rides.handler.player.impl;

import lombok.RequiredArgsConstructor;
import org.rides.dto.player.PlayerCredentialsDto;
import org.rides.entity.PlayerEntity;
import org.rides.handler.player.interfaces.PlayerRegisterHandler;
import org.rides.mapper.player.PlayerCredentialsMapper;
import org.rides.service.player.interfaces.PlayerCredentialsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerRegisterHandlerImpl implements PlayerRegisterHandler {
    private final PlayerCredentialsMapper mapper;
    private final PlayerCredentialsService registrationService;
    @Override
    public Boolean register(PlayerCredentialsDto dto) {
        PlayerEntity entity = mapper.toEntity(dto);
        return registrationService.register(entity);
    }
}
