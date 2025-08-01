package org.rides.service.player.impl;

import lombok.RequiredArgsConstructor;
import org.rides.entity.PlayerEntity;
import org.rides.service.player.interfaces.PlayerBalanceService;
import org.rides.service.player.interfaces.PlayerPersistenceService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerBalanceServiceImpl implements PlayerBalanceService {
    private final PlayerPersistenceService persistenceService;

    @Override
    public Boolean changeBalanceValue(PlayerEntity entity, Integer newBalance) {
        persistenceService.update(entity, "balance", entity.getBalance() + newBalance);
        return true;
    }
}
