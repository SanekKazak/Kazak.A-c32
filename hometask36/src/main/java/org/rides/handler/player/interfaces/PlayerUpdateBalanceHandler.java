package org.rides.handler.player.interfaces;

import org.rides.dto.PlayerDto;

public interface PlayerUpdateBalanceHandler {
    Boolean updatePlayerBalance(PlayerDto dto, Integer delta);
}
