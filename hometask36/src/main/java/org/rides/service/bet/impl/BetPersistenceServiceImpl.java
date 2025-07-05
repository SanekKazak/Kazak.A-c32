package org.rides.service.bet.impl;

import org.hibernate.SessionFactory;
import org.rides.config.PersistenceService;
import org.rides.entity.BetEntity;
import org.rides.service.bet.interfaces.BetPersistenceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BetPersistenceServiceImpl implements BetPersistenceService {
    private static final SessionFactory factory = PersistenceService.getPersistence();

    @Override
    public void create(BetEntity entity) {
        var session = factory.openSession();
        var transaction = session.beginTransaction();

        session.persist(entity);

        transaction.commit();
        session.close();
    }

    @Override
    public BetEntity read(UUID id) {
        var session = factory.openSession();
        var transaction = session.beginTransaction();

        BetEntity entity = session.createQuery(
                                "from BetEntity b " +
                                "left join fetch b.horse " +
                                "left join fetch b.player " +
                                "where b.id =: id ",
                        BetEntity.class)
                .setParameter("id", id)
                .getSingleResult();

        transaction.commit();
        session.close();
        return entity;
    }

    @Override
    public List<BetEntity> readAll() {
        var session = factory.openSession();
        var transaction = session.beginTransaction();

        List<BetEntity> resultList = session.createQuery(
                                "from BetEntity b " +
                                "left join fetch b.horse " +
                                "left join fetch b.player ",
                        BetEntity.class)
                .getResultList();

        transaction.commit();
        session.close();
        return resultList;
    }

    @Override
    public void update(BetEntity entity) {
        var session = factory.openSession();
        var transaction = session.beginTransaction();

        session.merge(entity);

        transaction.commit();
        session.close();
    }

    @Override
    public void delete(UUID id) {
        var session = factory.openSession();
        var transaction = session.beginTransaction();

        BetEntity entity = read(id);
        session.remove(entity);

        transaction.commit();
        session.close();
    }
}
