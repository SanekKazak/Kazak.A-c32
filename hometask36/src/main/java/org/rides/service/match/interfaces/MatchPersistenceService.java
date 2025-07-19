package org.rides.service.match.interfaces;

import org.rides.entity.MatchEntity;

import java.util.List;
import java.util.UUID;

public interface MatchPersistenceService {
    void create(MatchEntity entity);

    MatchEntity read(UUID id);

    void multiSave(MatchEntity entity, List<String> fields);

    List<MatchEntity> readAll();

    void update(MatchEntity entity);

    void delete(UUID id);

    void update(MatchEntity entity, String field, Object value);
}
