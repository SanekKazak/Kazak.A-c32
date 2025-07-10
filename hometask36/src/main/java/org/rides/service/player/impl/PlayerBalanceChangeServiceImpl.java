package org.rides.service.player.impl;

import lombok.RequiredArgsConstructor;
import org.rides.entity.PlayerEntity;
import org.rides.service.player.interfaces.PlayerBalanceChangeService;
import org.rides.service.player.interfaces.PlayerBalanceValidationService;
import org.rides.service.player.interfaces.PlayerPersistenceService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerBalanceChangeServiceImpl implements PlayerBalanceChangeService {
    private final PlayerPersistenceService persistenceService;
    private final PlayerBalanceValidationService validationService;

    @Override
    public Boolean changeBalanceValue(PlayerEntity entity, Integer newBalance) {
        Boolean validate = validationService.validate(entity, newBalance);

        if(validate==false){
            return false;
        }

        Integer currentBalance = entity.getBalance();
        Integer resultBalance = currentBalance + newBalance;

        entity.setBalance(resultBalance);
        persistenceService.update(entity);

        return true;
    }
}
