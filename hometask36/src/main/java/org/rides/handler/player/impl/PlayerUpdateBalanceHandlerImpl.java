package org.rides.handler.player.impl;

import lombok.RequiredArgsConstructor;
import org.rides.dto.player.PlayerBalanceUpdate;
import org.rides.entity.PlayerEntity;
import org.rides.handler.player.interfaces.PlayerUpdateBalanceHandler;
import org.rides.service.player.interfaces.PlayerAuthService;
import org.rides.service.player.interfaces.PlayerBalanceService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlayerUpdateBalanceHandlerImpl implements PlayerUpdateBalanceHandler {
    private final PlayerBalanceService changerService;
    private final PlayerAuthService authService;
    @Override
    public Boolean updatePlayerBalance(PlayerBalanceUpdate update, UUID token) {
        PlayerEntity entity = authService.findByToken(token);
        return changerService.changeBalanceValue(entity, update.getDelta());
    }
}
