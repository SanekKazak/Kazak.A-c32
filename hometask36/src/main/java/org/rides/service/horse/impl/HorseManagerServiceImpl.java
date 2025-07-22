package org.rides.service.horse.impl;

import lombok.RequiredArgsConstructor;
import org.rides.entity.HorseEntity;
import org.rides.service.horse.interfaces.HorseManagerService;
import org.rides.service.horse.interfaces.HorsePersistenceService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HorseManagerServiceImpl implements HorseManagerService {
    private final HorsePersistenceService persistenceService;

    @Override
    public Boolean create(HorseEntity entity) {
        persistenceService.create(entity);
        return true;
    }
}
