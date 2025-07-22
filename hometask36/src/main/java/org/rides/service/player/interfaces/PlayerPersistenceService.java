package org.rides.service.player.interfaces;

import org.rides.entity.PlayerEntity;

import java.util.List;
import java.util.UUID;

public interface PlayerPersistenceService {
    void create(PlayerEntity entity);

    PlayerEntity readByLogin(String login);

    PlayerEntity readById(UUID id);

    PlayerEntity readByToken(UUID token);

    List<PlayerEntity> readAll();

    void update(PlayerEntity entity);

    void update(PlayerEntity entity, String field, Object value);

    void delete(UUID id);

}
