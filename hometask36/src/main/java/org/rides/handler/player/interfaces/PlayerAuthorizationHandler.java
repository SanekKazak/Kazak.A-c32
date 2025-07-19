package org.rides.handler.player.interfaces;

import org.rides.dto.player.PlayerCredentialsDto;

import java.util.UUID;

public interface PlayerAuthorizationHandler {
    UUID authorize(PlayerCredentialsDto dto);
    Boolean deAuthorize(UUID token);
}
