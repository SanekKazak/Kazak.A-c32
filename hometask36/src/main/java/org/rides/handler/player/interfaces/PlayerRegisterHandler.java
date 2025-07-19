package org.rides.handler.player.interfaces;

import org.rides.dto.player.PlayerCredentialsDto;

public interface PlayerRegisterHandler {
    Boolean register(PlayerCredentialsDto dto);
}
