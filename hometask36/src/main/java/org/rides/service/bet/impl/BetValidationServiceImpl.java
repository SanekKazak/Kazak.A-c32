package org.rides.service.bet.impl;

import org.rides.entity.BetEntity;
import org.rides.service.bet.interfaces.BetValidationService;
import org.rides.utils.BackendErrorExceptionProxy;

public class BetValidationServiceImpl implements BetValidationService {
    @Override
    public BackendErrorExceptionProxy validate(BetEntity entity) {
        Integer balance = entity.getPlayer().getBalance();
        var errors = new BackendErrorExceptionProxy();
        if((balance-entity.getBet())>0){
            errors.addError("balance", "you don't have such money");
        }
        return errors;
    }
}
