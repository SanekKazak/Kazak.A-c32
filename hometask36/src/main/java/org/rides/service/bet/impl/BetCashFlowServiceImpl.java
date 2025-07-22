package org.rides.service.bet.impl;

import lombok.RequiredArgsConstructor;
import org.rides.entity.BetEntity;
import org.rides.entity.PlayerEntity;
import org.rides.service.bet.interfaces.BetCashFlowService;
import org.rides.service.bet.interfaces.BetPersistenceService;
import org.rides.service.bet.interfaces.BetValidationService;
import org.rides.service.player.interfaces.PlayerBalanceService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BetCashFlowServiceImpl implements BetCashFlowService {
    private final PlayerBalanceService changerService;
    private final BetValidationService validationService;
    private final BetPersistenceService betPersistenceService;

    @Override
    public BetEntity resolveInflow(BetEntity bet) {
        BetEntity entity = betPersistenceService.read(bet.getId());
        entity.setResult(bet.getResult());
        switch (entity.getResult()) {
            case WIN -> changerService.changeBalanceValue(entity.getPlayer(), (2) * entity.getBet());
            case PROCESS -> changerService.changeBalanceValue(entity.getPlayer(), entity.getBet());
            default -> {
                return null;
            }
        }
        return entity;
    }

    @Override
    public Optional<BetEntity> resolveOutflow(BetEntity entity) {
        if (!validationService.validate(entity)) {
            return Optional.empty();
        }

        PlayerEntity player = entity.getPlayer();

        player.setBalance(player.getBalance() - entity.getBet());

        return Optional.of(entity);
    }
}
