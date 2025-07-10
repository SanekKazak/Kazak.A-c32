package org.rides.service.player.interfaces;

import org.rides.entity.PlayerEntity;

public interface PlayerBalanceValidationService {
    Boolean validate(PlayerEntity entity, Integer delta);
}
