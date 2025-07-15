package org.rides.service.bet.interfaces;

import org.rides.entity.BetEntity;
import org.rides.utils.BackendErrorExceptionProxy;

public interface BetValidationService {
    BackendErrorExceptionProxy validate(BetEntity entity);
}
