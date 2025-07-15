package org.rides.handler.player.impl;

import lombok.RequiredArgsConstructor;
import org.rides.dto.PlayerBalanceUpdate;
import org.rides.entity.PlayerEntity;
import org.rides.handler.player.interfaces.PlayerUpdateBalanceHandler;
import org.rides.service.player.interfaces.PlayerAuthService;
import org.rides.service.player.interfaces.PlayerBalanceService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerUpdateBalanceHandlerImpl implements PlayerUpdateBalanceHandler {
    private final PlayerBalanceService changerService;
    private final PlayerAuthService authService;
    @Override
    public Boolean updatePlayerBalance(PlayerBalanceUpdate update) {
        PlayerEntity entity = authService.findByToken(update.getToken());
        return changerService.changeBalanceValue(entity, update.getDelta());
    }
}
