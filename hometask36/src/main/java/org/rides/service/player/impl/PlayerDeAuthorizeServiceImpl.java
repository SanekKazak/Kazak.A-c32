package org.rides.service.player.impl;

import lombok.RequiredArgsConstructor;
import org.rides.entity.PlayerEntity;
import org.rides.service.player.interfaces.PlayerDeAuthorizeService;
import org.rides.service.player.interfaces.PlayerPersistenceService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerDeAuthorizeServiceImpl implements PlayerDeAuthorizeService {
    private final PlayerPersistenceService persistenceService;
    @Override
    public Boolean deAuthorize(PlayerEntity entity) {
        persistenceService.update(entity, "token", "null");
        return true;
    }
}
