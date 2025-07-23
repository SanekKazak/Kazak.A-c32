package org.rides.handler.player.interfaces;

import org.rides.dto.player.PlayerCredentialsDto;
import org.rides.entity.PlayerEntity;

import java.util.UUID;

public interface PlayerAuthorizationHandler {
    PlayerEntity authorize(PlayerCredentialsDto dto);
    Boolean deAuthorize(UUID token);
}
