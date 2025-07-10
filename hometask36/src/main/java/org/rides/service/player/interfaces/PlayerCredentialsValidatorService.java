package org.rides.service.player.interfaces;

import org.rides.config.BackendErrorExceptionProxy;
import org.rides.entity.PlayerEntity;

public interface PlayerCredentialsValidatorService {
    BackendErrorExceptionProxy validate(PlayerEntity entity);
    BackendErrorExceptionProxy validateAuthorization(PlayerEntity entity);
    BackendErrorExceptionProxy validateRegistration(PlayerEntity entity);
}
