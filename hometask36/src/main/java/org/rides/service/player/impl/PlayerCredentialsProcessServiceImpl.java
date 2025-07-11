package org.rides.service.player.impl;

import lombok.RequiredArgsConstructor;
import org.rides.entity.PlayerEntity;
import org.rides.service.player.interfaces.PlayerCredentialsProcessService;
import org.rides.service.player.interfaces.PlayerCredentialsValidatorService;
import org.rides.service.player.interfaces.PlayerPersistenceService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlayerCredentialsProcessServiceImpl implements PlayerCredentialsProcessService {
    private final PlayerPersistenceService persistenceService;
    private final PlayerCredentialsValidatorService validatorService;

    @Override
    public UUID authorize(PlayerEntity entity) {
        var errors = validatorService.validate(entity);

        if(errors.isExist()){
            System.out.println(errors);
            return null;
        }

        UUID token = UUID.randomUUID();
        entity.setToken(token);
//        persistenceService.update(entity, "token", token.toString());
        return token;
    }

    @Override
    public Boolean register(PlayerEntity entity) {
        var errors = validatorService.validate(entity);

        if(errors.isExist()){
            System.out.println(errors);
            return false;
        }

        persistenceService.create(entity);
        return true;
    }
}
