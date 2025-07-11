package org.rides.service.horse.impl;

import org.hibernate.SessionFactory;
import org.rides.utils.PersistenceService;
import org.rides.entity.HorseEntity;
import org.rides.service.horse.interfaces.HorsePersistenceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HorsePersistenceServiceImpl implements HorsePersistenceService {
    private final SessionFactory factory;

    public HorsePersistenceServiceImpl(PersistenceService service) {
        factory = service.getFactory();
    }

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

        var entity = session.createQuery(
                        "from HorseEntity " +
                                "where name =: name"
                        , HorseEntity.class)
                .setParameter("name", name)
                .getSingleResult();

        transaction.commit();
        session.close();
        return entity;
    }

    @Override
    public HorseEntity read(UUID id) {
        var session = factory.openSession();
        var transaction = session.beginTransaction();

        var entity = session.createQuery(
                        "from HorseEntity " +
                                "where id =: id"
                        , HorseEntity.class)
                .setParameter("id", id)
                .getSingleResult();

        transaction.commit();
        session.close();
        return entity;
    }

    @Override
    public List<HorseEntity> readAll() {
        var session = factory.openSession();
        var transaction = session.beginTransaction();

        List<HorseEntity> resultList = session.createQuery(
                        "from HorseEntity",
                HorseEntity.class
        ).getResultList();

        transaction.commit();
        session.close();
        return resultList;
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
    public void update(List<HorseEntity> horses) {
        var session = factory.openSession();
        var transaction = session.beginTransaction();

        horses.forEach(session::merge);

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
