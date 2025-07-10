package org.rides.service.player.impl;

import org.rides.entity.PlayerEntity;
import org.rides.service.player.interfaces.PlayerBalanceValidationService;
import org.rides.service.player.interfaces.PlayerPersistenceService;
import org.springframework.stereotype.Service;

@Service
public class PlayerBalanceValidationServiceImpl implements PlayerBalanceValidationService {
    private PlayerPersistenceService persistenceService;

    public PlayerBalanceValidationServiceImpl(PlayerPersistenceService persistenceService) {
        this.persistenceService = persistenceService;
    }

    @Override
    public Boolean validate(PlayerEntity entity, Integer delta) {
        Integer balance = entity.getBalance();
        return (balance-delta)>0;
    }
}
