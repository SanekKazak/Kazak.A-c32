package org.rides.handler.player.interfaces;

import org.rides.dto.HorseDto;
import org.rides.dto.PlayerDto;
import org.rides.entity.PlayerEntity;

import java.util.UUID;

public interface PlayerUpdateBalanceHandler {
    Boolean updatePlayerBalance(UUID id, Integer delta);
}
