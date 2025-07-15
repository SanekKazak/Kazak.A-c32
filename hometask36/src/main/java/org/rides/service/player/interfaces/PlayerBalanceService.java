package org.rides.service.player.interfaces;

import org.rides.entity.PlayerEntity;

public interface PlayerBalanceService {
    Boolean changeBalanceValue(PlayerEntity entity, Integer newBalance);
}
