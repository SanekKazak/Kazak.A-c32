package org.rides.service.player.impl;

import lombok.RequiredArgsConstructor;
import org.rides.entity.PlayerEntity;
import org.rides.service.player.interfaces.PlayerAuthService;
import org.rides.service.player.interfaces.PlayerPersistenceService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlayerAuthServiceImpl implements PlayerAuthService {
    private final PlayerPersistenceService persistenceService;
    @Override
    public PlayerEntity findByToken(UUID token) {
        return persistenceService.readByToken(token);
    }
}
