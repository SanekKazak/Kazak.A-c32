package org.rides.service.horse.interfaces;

import org.rides.entity.HorseEntity;
import org.rides.entity.PlayerEntity;

import java.util.List;
import java.util.UUID;

public interface HorsePersistenceService {
    void create(HorseEntity entity);
    void read(String login);
    void read(UUID id);
    List<HorseEntity> readAll();
    void update(HorseEntity entity);
    void delete(HorseEntity entity);
}
