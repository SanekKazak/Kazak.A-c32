package org.rides.service.horse.impl;

import org.hibernate.SessionFactory;
import org.rides.config.PersistenceService;
import org.rides.entity.HorseEntity;
import org.rides.service.horse.interfaces.HorsePersistenceService;

import java.util.List;
import java.util.UUID;

public class HorsePersistenceServiceImpl implements HorsePersistenceService {
    private static final SessionFactory factory = PersistenceService.getPersistence();

    @Override
    public void create(HorseEntity entity) {
        var session = factory.openSession();
        var transaction = session.beginTransaction();

        session.persist(entity);

        transaction.commit();
        session.close();
    }

    @Override
    public HorseEntity read(String name) {
        var session = factory.openSession();
        var transaction = session.beginTransaction();



        transaction.commit();
        session.close();
        return null;
    }

    @Override
    public HorseEntity read(UUID id) {
        var session = factory.openSession();
        var transaction = session.beginTransaction();

        HorseEntity entity = session.find(HorseEntity.class, id);

        transaction.commit();
        session.close();

        return entity;
    }

    @Override
    public List<HorseEntity> readAll() {
        var session = factory.openSession();
        var transaction = session.beginTransaction();

        List<HorseEntity> entities = session.createQuery("from HorseEntity", HorseEntity.class)
                .getResultList();

        transaction.commit();
        session.close();
        return entities;
    }

    @Override
    public void update(HorseEntity entity) {
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

        HorseEntity entity = read(id);
        session.remove(entity);

        transaction.commit();
        session.close();

    }
}
