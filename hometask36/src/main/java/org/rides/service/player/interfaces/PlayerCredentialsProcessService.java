package org.rides.service.player.interfaces;

import org.rides.entity.PlayerEntity;

import java.util.UUID;

public interface PlayerCredentialsProcessService {
    Boolean register(PlayerEntity entity);
    UUID authorize(PlayerEntity entity);
}
