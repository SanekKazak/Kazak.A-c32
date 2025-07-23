package org.rides.service.player.interfaces;

import org.rides.entity.PlayerEntity;

public interface PlayerCredentialsService {
    Boolean register(PlayerEntity entity);

    PlayerEntity authorize(PlayerEntity entity);
}
