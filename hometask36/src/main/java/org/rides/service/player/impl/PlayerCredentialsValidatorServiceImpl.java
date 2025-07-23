package org.rides.service.player.impl;

import lombok.RequiredArgsConstructor;
import org.rides.entity.PlayerEntity;
import org.rides.service.player.interfaces.PlayerCredentialsValidatorService;
import org.rides.service.player.interfaces.PlayerPersistenceService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerCredentialsValidatorServiceImpl implements PlayerCredentialsValidatorService {
    private final PlayerPersistenceService persistenceService;

    @Override
    public Boolean validateRegistration(PlayerEntity entity) {
        PlayerEntity exist = persistenceService.readByLogin(entity.getLogin());
        if (exist != null) {
            return false;
        }
        return true;
    }
}
