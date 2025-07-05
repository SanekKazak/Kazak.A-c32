package org.rides.service.horse.impl;

import org.rides.entity.HorseEntity;
import org.rides.service.horse.interfaces.HorseRunService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class HorseRunServiceImpl implements HorseRunService {
    private HorsePersistenceServiceImpl persistenceService;

    public HorseRunServiceImpl(HorsePersistenceServiceImpl persistenceService) {
        this.persistenceService = persistenceService;
    }

    @Override
    public void speedMeasure(HorseEntity horse) {
        Random random = new Random();
        var i = random.nextDouble(500);
        var i1 = random.nextDouble(300);
        var result = i + i1;

        horse.setAvgSpeed(result);
        persistenceService.update(horse);
    }
}
