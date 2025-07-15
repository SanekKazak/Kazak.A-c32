package org.rides.service.player.impl;

import lombok.RequiredArgsConstructor;
import org.rides.entity.PlayerEntity;
import org.rides.service.player.interfaces.PlayerCredentialsService;
import org.rides.service.player.interfaces.PlayerCredentialsValidatorService;
import org.rides.service.player.interfaces.PlayerPersistenceService;
import org.rides.utils.BackendErrorExceptionProxy;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlayerCredentialsServiceImpl implements PlayerCredentialsService {
    private final PlayerPersistenceService persistenceService;
    private final PlayerCredentialsValidatorService validatorService;

    @Override
    public UUID authorize(PlayerEntity entity) {
        BackendErrorExceptionProxy errors = validatorService.validate(entity);

        if(errors.isExist()){
            System.out.println(errors);
            return null;
        }

        PlayerEntity dbEntity = persistenceService.readByLogin(entity.getLogin());
        if(!dbEntity.getPassword().equals(entity.getPassword())){
            errors.addError("password", "password is not valid");
        }

        UUID token = UUID.randomUUID();
        persistenceService.update(dbEntity, "token", token);
        return token;
    }

    @Override
    public Boolean register(PlayerEntity entity) {
        var errors = validatorService.validateRegistration(entity);

        if(errors.isExist()){
            System.out.println(errors);
            return false;
        }

        persistenceService.create(entity);
        return true;
    }
}
