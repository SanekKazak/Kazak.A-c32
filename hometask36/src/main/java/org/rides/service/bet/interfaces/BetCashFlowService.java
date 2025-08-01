package org.rides.service.bet.interfaces;

import org.rides.entity.BetEntity;

import java.util.Optional;

public interface BetCashFlowService {
    BetEntity resolveInflow(BetEntity bet);

    Optional<BetEntity> resolveOutflow(BetEntity entity);
}
