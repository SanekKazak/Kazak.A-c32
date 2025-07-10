package org.rides.service.player.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.rides.config.PersistenceService;
import org.rides.entity.PlayerEntity;
import org.rides.service.player.interfaces.PlayerPersistenceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PlayerPersistenceServiceImpl implements PlayerPersistenceService {
    private final SessionFactory factory;

    public PlayerPersistenceServiceImpl(PersistenceService service) {
        factory = service.getFactory();
    }

    @Override
    public void create(PlayerEntity entity) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(entity);

        transaction.commit();
        session.close();
    }

    @Override
    public PlayerEntity read(String login) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        var entity = session.createQuery(
                        "from PlayerEntity p " +
                                "left join fetch p.bet b " +
                                "left join fetch b.horse " +
                                "where p.login =: login",
                        PlayerEntity.class)
                .setParameter("login", login)
                .getSingleResult();

        transaction.commit();
        session.close();
        return entity;
    }

    @Override
    public PlayerEntity read(UUID id) {
        var session = factory.openSession();
        var transaction = session.beginTransaction();

        var entity = session.createQuery(
                        "from PlayerEntity p " +
                                "left join fetch p.bet b " +
                                "left join fetch b.horse " +
                                "where p.id =: id",
                        PlayerEntity.class)
                .setParameter("id", id)
                .getSingleResult();

        transaction.commit();
        session.close();
        return entity;
    }

    @Override
    public List<PlayerEntity> readAll() {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        var entities = session.createQuery(
                        "from PlayerEntity p " +
                                "left join fetch p.bet b " +
                                "left join fetch b.horse",
                        PlayerEntity.class)
                .getResultList();

        transaction.commit();
        session.close();
        return entities;
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
