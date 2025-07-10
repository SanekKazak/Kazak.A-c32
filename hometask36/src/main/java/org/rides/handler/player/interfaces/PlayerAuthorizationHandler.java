package org.rides.handler.player.interfaces;

import org.rides.dto.PlayerCredentialsDto;
import org.rides.dto.PlayerDto;

import java.util.UUID;

public interface PlayerAuthorizationHandler {
    UUID authorize(PlayerCredentialsDto dto);
    Boolean deAuthorize(PlayerDto dto);
}
