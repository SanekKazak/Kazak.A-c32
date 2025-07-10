package org.rides.service.player.interfaces;

import org.rides.entity.PlayerEntity;

import java.util.List;

public interface PlayerCredentialsValidatorService {
    List<Exception> validate(PlayerEntity entity);
    List<Exception> validateAuthorization(PlayerEntity entity);
    List<Exception> validateRegistration(PlayerEntity entity);
}
