package org.rides.handler.player.interfaces;

import org.rides.dto.PlayerCredentialsDto;

public interface PlayerRegisterHandler {
    Boolean register(PlayerCredentialsDto dto);
}
