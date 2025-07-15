package org.rides.service.bet.impl;

import lombok.RequiredArgsConstructor;
import org.rides.entity.BetEntity;
import org.rides.service.bet.interfaces.BetManagerService;
import org.rides.service.bet.interfaces.BetPersistenceService;
import org.rides.service.bet.interfaces.BetValidationService;
import org.rides.utils.BackendErrorExceptionProxy;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BetManagerServiceImpl implements BetManagerService {
    private final BetPersistenceService persistenceService;
    private final BetValidationService validationService;
    @Override
    public Boolean create(BetEntity entity) {
        BackendErrorExceptionProxy validate = validationService.validate(entity);
        if(validate.isExist()){
            return false;
        }
        persistenceService.create(entity);
        return true;
    }
}
