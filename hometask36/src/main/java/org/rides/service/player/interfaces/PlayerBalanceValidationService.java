package org.rides.service.player.interfaces;

import org.rides.entity.PlayerEntity;

import java.util.UUID;

public interface PlayerBalanceValidationService {
    Boolean validate(UUID id, Integer delta);
}
