package org.rides.handler.player.impl;

import lombok.RequiredArgsConstructor;
import org.rides.dto.player.PlayerCredentialsDto;
import org.rides.entity.PlayerEntity;
import org.rides.handler.player.interfaces.PlayerAuthorizationHandler;
import org.rides.mapper.player.PlayerCredentialsMapper;
import org.rides.service.player.interfaces.PlayerAuthService;
import org.rides.service.player.interfaces.PlayerCredentialsService;
import org.rides.service.player.interfaces.PlayerDeAuthorizeService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlayerAuthorizationHandlerImpl implements PlayerAuthorizationHandler {
    private final PlayerCredentialsMapper credentialsMapper;
    private final PlayerCredentialsService credentialsService;
    private final PlayerAuthService authService;
    private final PlayerDeAuthorizeService deAuthorizeService;
    @Override
    public UUID authorize(PlayerCredentialsDto dto) {
        PlayerEntity entity = credentialsMapper.toEntity(dto);
        return credentialsService.authorize(entity);
    }

    @Override
    public Boolean deAuthorize(UUID token) {
        PlayerEntity entity = authService.findByToken(token);
        return deAuthorizeService.deAuthorize(entity);
    }
}
