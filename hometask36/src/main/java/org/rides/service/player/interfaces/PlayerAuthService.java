package org.rides.service.player.interfaces;

import org.rides.entity.PlayerEntity;

import java.util.UUID;

public interface PlayerAuthService {
    PlayerEntity findByToken(UUID token);
}
