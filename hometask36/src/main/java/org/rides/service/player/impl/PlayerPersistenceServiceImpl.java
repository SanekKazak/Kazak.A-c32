package org.rides.service.player.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.rides.config.PersistenceService;
import org.rides.entity.PlayerEntity;
import org.rides.service.player.interfaces.PlayerPersistenceService;

import java.util.List;
import java.util.UUID;

public class PlayerPersistenceServiceImpl implements PlayerPersistenceService {
    private static final SessionFactory factory = PersistenceService.getPersistence();
    @Override
    public void create(PlayerEntity entity) {

    }

    @Override
    public PlayerEntity read(String login) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        var entity  = session.createQuery ("from PlayerEntity p " +
                        "where login =: login",
                        PlayerEntity.class)
                .setParameter("login", login)
                .getSingleResult();

        transaction.commit();
        session.close();
        return entity;
    }

    @Override
    public PlayerEntity read(UUID id) {
        return null;
    }

    @Override
    public List<PlayerEntity> readAll() {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        var entity  = session.createQuery ("select p " +
                                "from PlayerEntity p " +
                                "left join fetch p.bet b " +
                                "left join fetch b.horse " +
                                "where login =: login",
                        PlayerEntity.class)
                .setParameter("login", login)
                .getSingleResult();

        transaction.commit();
        session.close();
        return List.of();
    }

    @Override
    public void update(PlayerEntity entity) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.merge(entity);

        transaction.commit();
        session.close();
    }

    @Override
    public void delete(UUID id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        PlayerEntity entity = read(id);
        session.remove(entity);

        transaction.commit();
        session.close();
    }
}
