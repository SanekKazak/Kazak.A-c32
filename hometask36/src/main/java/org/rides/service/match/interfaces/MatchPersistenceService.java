package org.rides.service.match.interfaces;

import org.rides.entity.MatchEntity;
import org.rides.entity.PlayerEntity;

import java.util.List;
import java.util.UUID;

public interface MatchPersistenceService {
    void create(MatchEntity entity);
    MatchEntity read(UUID id);
    List<MatchEntity> readAll();
    void update(MatchEntity entity);
    void delete(UUID id);
    void update(MatchEntity entity, String field, Object value);
}
