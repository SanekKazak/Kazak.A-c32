package org.rides.service.player.interfaces;

import org.rides.entity.PlayerEntity;

import java.util.List;
import java.util.UUID;

public interface PlayerPersistenceService {
    void create(PlayerEntity entity);
    void read(String login);
    void read(UUID id);
    List<PlayerEntity> readAll();
    void update(PlayerEntity entity);
    void delete(PlayerEntity entity);
}
