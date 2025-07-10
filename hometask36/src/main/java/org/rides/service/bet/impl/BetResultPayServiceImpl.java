package org.rides.service.bet.impl;

import lombok.RequiredArgsConstructor;
import org.rides.entity.BetEntity;
import org.rides.service.bet.interfaces.BetResultPayService;
import org.rides.service.player.interfaces.PlayerBalanceChangeService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BetResultPayServiceImpl implements BetResultPayService {
    private final PlayerBalanceChangeService changerService;

    @Override
    public BetEntity resolveResult(BetEntity entity) {
        switch(entity.getResult()){
            case WIN -> changerService.changeBalanceValue(entity.getPlayer(), entity.getBet());
            case LOSE -> changerService.changeBalanceValue(entity.getPlayer(), (-1)*entity.getBet());
            default -> {
                return null;
            }
        }
        return entity;
    }
}
