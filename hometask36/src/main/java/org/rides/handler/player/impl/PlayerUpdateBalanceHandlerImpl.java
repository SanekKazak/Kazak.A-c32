package org.rides.handler.player.impl;

import lombok.RequiredArgsConstructor;
import org.rides.entity.PlayerEntity;
import org.rides.handler.player.interfaces.PlayerUpdateBalanceHandler;
import org.rides.service.player.interfaces.PlayerBalanceValidationService;
import org.rides.service.player.interfaces.PlayerPersistenceService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlayerUpdateBalanceHandlerImpl implements PlayerUpdateBalanceHandler {
    private final PlayerPersistenceService persistenceService;
    private final PlayerBalanceValidationService balanceValidationService;

    @Override
    public Boolean updatePlayerBalance(UUID id, Integer delta) {
        Boolean validate = balanceValidationService.validate(id, delta);

        if(validate==false){
            return false;
        }

        PlayerEntity entity = persistenceService.read(id);
        Integer currentBalance = entity.getBalance();
        Integer resultBalance = currentBalance + delta;

        entity.setBalance(resultBalance);
        persistenceService.update(entity);

        return true;
    }
}
