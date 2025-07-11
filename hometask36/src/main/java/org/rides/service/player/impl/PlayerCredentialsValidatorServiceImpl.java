package org.rides.service.player.impl;

import lombok.RequiredArgsConstructor;
import org.rides.utils.BackendErrorExceptionProxy;
import org.rides.entity.PlayerEntity;
import org.rides.service.player.interfaces.PlayerCredentialsValidatorService;
import org.rides.service.player.interfaces.PlayerPersistenceService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerCredentialsValidatorServiceImpl implements PlayerCredentialsValidatorService {
    private final PlayerPersistenceService persistenceService;
    @Override
    public BackendErrorExceptionProxy validate(PlayerEntity entity) {
        var errors = new BackendErrorExceptionProxy();
        String password = entity.getPassword();
        String login = entity.getLogin();
        if(password ==null || password.isBlank()){
            errors.addError("password", "null password");
        }
        if(password ==null || password.isBlank()){
            errors.addError("login", "null login");
        }
        return errors;
    }

    @Override
    public BackendErrorExceptionProxy validateAuthorization(PlayerEntity entity) {
        var errors = validate(entity);

        try {
            persistenceService.read(entity.getLogin());
        }catch (Exception e){
            errors.addError("login", e.getMessage());
        }

        return errors;
    }

    @Override
    public BackendErrorExceptionProxy validateRegistration(PlayerEntity entity) {
        var errors = validate(entity);

        if(entity.getPassword().length()<4){
            errors.addError("password", "password to low");
        }

        PlayerEntity exist = persistenceService.read(entity.getLogin());

        if(exist!=null){
            errors.addError("login", "login already exist");
        }

        return errors;
    }
}
