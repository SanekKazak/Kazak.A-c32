package org.rides.service.horse.interfaces;

import org.rides.entity.HorseEntity;

import java.util.List;
import java.util.UUID;

public interface HorsePersistenceService {
    void create(HorseEntity entity);

    HorseEntity read(String name);

    HorseEntity read(UUID id);

    List<HorseEntity> readAll();

    List<HorseEntity> readAllByIds(List<UUID> ids);

    void multiSave(HorseEntity entity, List<String> fields);

    void update(HorseEntity entity);

    void update(List<HorseEntity> horses);

    void delete(UUID id);

    void update(HorseEntity entity, String field, Object value);

}
