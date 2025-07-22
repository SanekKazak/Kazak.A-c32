package org.rides.service.bet.impl;

import org.rides.entity.BetEntity;
import org.rides.service.bet.interfaces.BetValidationService;
import org.springframework.stereotype.Service;

@Service
public class BetValidationServiceImpl implements BetValidationService {
    @Override
    public Boolean validate(BetEntity entity) {
        Integer balance = entity.getPlayer().getBalance();
        if((balance-entity.getBet())<0){
            return false;
        }
        return true;
    }
}
