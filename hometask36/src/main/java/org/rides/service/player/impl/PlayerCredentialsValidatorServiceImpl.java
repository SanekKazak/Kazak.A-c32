package org.rides.service.player.impl;

import lombok.RequiredArgsConstructor;
import org.rides.entity.PlayerEntity;
import org.rides.service.player.interfaces.PlayerCredentialsValidatorService;
import org.rides.service.player.interfaces.PlayerPersistenceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerCredentialsValidatorServiceImpl implements PlayerCredentialsValidatorService {
    private final PlayerPersistenceService persistenceService;
    @Override
    public List<Exception> validate(PlayerEntity entity) {
        var errors = new ArrayList<Exception>();
        String password = entity.getPassword();
        String login = entity.getLogin();
        if(password ==null || password.isBlank()){
            errors.add(new Exception("Password is empty"));
        }
        if(password ==null || password.isBlank()){
            errors.add(new Exception("Login is empty"));
        }
        return errors;
    }

    @Override
    public List<Exception> validateAuthorization(PlayerEntity entity) {
        List<Exception> validate = validate(entity);

        if(!validate.isEmpty()){
            return validate;
        }

        PlayerEntity entity1 = persistenceService.read(entity.getLogin());
        return List.of();
    }

    @Override
    public List<Exception> validateRegistration(PlayerEntity entity) {
        return List.of();
    }
}
