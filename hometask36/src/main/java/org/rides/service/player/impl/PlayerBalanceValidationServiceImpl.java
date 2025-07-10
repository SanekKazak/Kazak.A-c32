package org.rides.service.player.impl;

import org.rides.config.BackendErrorExceptionProxy;
import org.rides.entity.PlayerEntity;
import org.rides.service.player.interfaces.PlayerBalanceValidationService;
import org.springframework.stereotype.Service;

@Service
public class PlayerBalanceValidationServiceImpl implements PlayerBalanceValidationService {
    @Override
    public BackendErrorExceptionProxy validate(PlayerEntity entity, Integer delta) {
        Integer balance = entity.getBalance();
        var errors = new BackendErrorExceptionProxy();
        if((balance-delta)>0){
            errors.addError("balance", "you dont have such money");
        }
        return errors;
    }
}
