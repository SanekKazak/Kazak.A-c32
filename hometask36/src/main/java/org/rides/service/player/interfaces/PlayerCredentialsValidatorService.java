package org.rides.service.player.interfaces;

import org.rides.entity.PlayerEntity;

public interface PlayerCredentialsValidatorService {
    Boolean validateRegistration(PlayerEntity entity);
}
