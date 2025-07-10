package org.rides.handler.player.impl;

import lombok.RequiredArgsConstructor;
import org.rides.dto.PlayerCredentialsDto;
import org.rides.dto.PlayerDto;
import org.rides.entity.PlayerEntity;
import org.rides.handler.player.interfaces.PlayerAuthorizationHandler;
import org.rides.mapper.player.PlayerCredentialsMapper;
import org.rides.service.player.interfaces.PlayerCredentialsService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlayerAuthorizationHandlerImpl implements PlayerAuthorizationHandler {
    private final PlayerCredentialsMapper credentialsMapper;
    private final PlayerCredentialsService credentialsService;
    @Override
    public UUID authorize(PlayerCredentialsDto dto) {
        PlayerEntity entity = credentialsMapper.toEntity(dto);
        return credentialsService.authorize(entity);
    }

    @Override
    public Boolean deAuthorize(PlayerDto dto) {
        return null;
    }
}
