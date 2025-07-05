package org.rides.service.player.impl;

import org.rides.entity.PlayerEntity;
import org.rides.service.player.interfaces.PlayerBalanceValidationService;
import org.rides.service.player.interfaces.PlayerPersistenceService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PlayerBalanceValidationServiceImpl implements PlayerBalanceValidationService {
    private PlayerPersistenceService persistenceService;

    public PlayerBalanceValidationServiceImpl(PlayerPersistenceService persistenceService) {
        this.persistenceService = persistenceService;
    }

    @Override
    public Boolean validate(UUID id, Integer delta) {
        PlayerEntity entity = persistenceService.read(id);
        if(entity==null){
            return false;
        }
        Integer balance = entity.getBalance();

        return (balance-delta)>0;
    }
}
