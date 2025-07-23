package org.rides.handler.player.interfaces;

import org.rides.dto.player.PlayerBalanceUpdate;

import java.util.UUID;

public interface PlayerUpdateBalanceHandler {
    Boolean updatePlayerBalance(PlayerBalanceUpdate update, UUID token);
}
