package org.rides.service.horse.interfaces;

import org.rides.entity.HorseEntity;
import org.rides.entity.PlayerEntity;

import java.util.List;
import java.util.UUID;

public interface HorsePersistenceService {
    void create(HorseEntity entity);
    HorseEntity read(String name);
    HorseEntity read(UUID id);
    List<HorseEntity> readAll();
    void update(HorseEntity entity);
    void update(List<HorseEntity> horses);
    void delete(UUID id);
    void update(HorseEntity entity, String field, Object value);
}
