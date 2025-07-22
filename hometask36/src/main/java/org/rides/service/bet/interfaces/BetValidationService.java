package org.rides.service.bet.interfaces;

import org.rides.entity.BetEntity;

public interface BetValidationService {
    Boolean validate(BetEntity entity);
}
