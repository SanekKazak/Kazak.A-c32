package org.rides.service.player.impl;

import lombok.RequiredArgsConstructor;
import org.rides.entity.PlayerEntity;
import org.rides.service.player.interfaces.PlayerCredentialsService;
import org.rides.service.player.interfaces.PlayerCredentialsValidatorService;
import org.rides.service.player.interfaces.PlayerPersistenceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlayerCredentialsServiceImpl implements PlayerCredentialsService {
    private final PlayerPersistenceService persistenceService;
    private final PlayerCredentialsValidatorService validatorService;

    @Override
    public UUID authorize(PlayerEntity entity) {
        List<Exception> validate = validatorService.validate(entity);

        if(!validate.isEmpty()){
            validate.forEach(System.out::println);
            return null;
        }

        UUID token = UUID.randomUUID();
        entity.setToken(token);
        persistenceService.update(entity);
        return token;
    }

    @Override
    public Boolean register(PlayerEntity entity) {
        List<Exception> validate = validatorService.validate(entity);

        if(!validate.isEmpty()){
            validate.forEach(System.out::println);
            return false;
        }

        persistenceService.create(entity);
        return true;
    }
}
