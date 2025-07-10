package org.rides.service.player.interfaces;

import org.rides.entity.PlayerEntity;

import java.util.List;
import java.util.UUID;

public interface PlayerPersistenceService {
    void create(PlayerEntity entity);
    PlayerEntity read(String login);
    PlayerEntity read(UUID id);
    List<PlayerEntity> readAll();
    void update(PlayerEntity entity);
    void delete(UUID id);

}
