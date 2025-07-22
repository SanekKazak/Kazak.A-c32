package org.rides.service.player.impl;

import lombok.RequiredArgsConstructor;
import org.rides.entity.PlayerEntity;
import org.rides.service.player.interfaces.PlayerCredentialsService;
import org.rides.service.player.interfaces.PlayerCredentialsValidatorService;
import org.rides.service.player.interfaces.PlayerPersistenceService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlayerCredentialsServiceImpl implements PlayerCredentialsService {
    private final PlayerPersistenceService persistenceService;
    private final PlayerCredentialsValidatorService validatorService;

    @Override
    public UUID authorize(PlayerEntity entity) {
        PlayerEntity dbEntity = persistenceService.readByLogin(entity.getLogin());
        if (!dbEntity.getPassword().equals(entity.getPassword())) {
            return null;
        }

        UUID token = UUID.randomUUID();
        persistenceService.update(dbEntity, "token", token);
        return token;
    }

    @Override
    public Boolean register(PlayerEntity entity) {
        if (!validatorService.validateRegistration(entity)) {
            return false;
        }

        persistenceService.create(entity);
        return true;
    }
}
