package org.rides.service.player.interfaces;

import org.rides.config.BackendErrorExceptionProxy;
import org.rides.entity.PlayerEntity;

public interface PlayerBalanceValidationService {
    BackendErrorExceptionProxy validate(PlayerEntity entity, Integer delta);
}
