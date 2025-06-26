package org.rides.service.player.impl;

import org.hibernate.SessionFactory;
import org.rides.config.PersistenceService;
import org.rides.entity.PlayerEntity;
import org.rides.service.player.interfaces.PlayerPersistenceService;

import java.util.List;
import java.util.UUID;

public class PlayerPersistenceServiceImpl implements PlayerPersistenceService {
    private final SessionFactory factory = PersistenceService.getPersistence();
    @Override
    public void create(PlayerEntity entity) {
        var session = factory.openSession();
        var transaction = session.beginTransaction();

        session.persist(entity);

        transaction.commit();
        session.close();
    }

    @Override
    public void read(String login) {

    }

    @Override
    public void read(UUID id) {

    }

    @Override
    public List<PlayerEntity> readAll() {
        return List.of();
    }

    @Override
    public void update(PlayerEntity entity) {

    }

    @Override
    public void delete(PlayerEntity entity) {

    }
}
