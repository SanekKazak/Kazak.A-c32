package org.rides.service.horse.impl;

import org.rides.entity.HorseEntity;
import org.rides.service.horse.interfaces.HorseRunService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class HorseRunServiceImpl implements HorseRunService {

    @Override
    public List<HorseEntity> measureHorsesSpeed(List<HorseEntity> horses) {
        Random random = new Random();

        return horses.stream()
                .peek(horse -> {
                    var randomResult = random.nextDouble(500);
                    var randomResult1 = random.nextDouble(300);
                    var result = randomResult + randomResult1;
                    horse.setAvgSpeed(result);
                }).toList();
    }
}
