package org.rides.service.bet.impl;

import lombok.RequiredArgsConstructor;
import org.rides.entity.BetEntity;
import org.rides.service.bet.interfaces.BetCashFlowService;
import org.rides.service.bet.interfaces.BetManagerService;
import org.rides.service.bet.interfaces.BetPersistenceService;
import org.rides.service.player.interfaces.PlayerAuthService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BetManagerServiceImpl implements BetManagerService {
    private final BetPersistenceService persistenceService;
    private final PlayerAuthService authService;
    private final BetCashFlowService cashFlowService;

    @Override
    public Boolean create(BetEntity entity) {
        Optional<BetEntity> betEntity = cashFlowService.resolveOutflow(entity);
        if (betEntity.isEmpty()) {
            return false;
        }
        BetEntity result = betEntity.get();
        persistenceService.create(result);
        return true;
    }
}
