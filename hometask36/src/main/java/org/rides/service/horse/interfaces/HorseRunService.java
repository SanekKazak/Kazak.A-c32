package org.rides.service.horse.interfaces;

import org.rides.entity.HorseEntity;

import java.util.List;

public interface HorseRunService {
    List<HorseEntity> measureHorsesSpeed(List<HorseEntity> horses);
}
