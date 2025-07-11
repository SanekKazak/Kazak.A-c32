package org.rides.service.match.impl;

import org.hibernate.SessionFactory;
import org.rides.utils.PersistenceService;
import org.rides.entity.MatchEntity;
import org.rides.service.match.interfaces.MatchPersistenceService;
import org.rides.utils.PersistenceUpdateService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MatchPersistenceServiceImpl implements MatchPersistenceService {
    private final SessionFactory factory;
    private final PersistenceUpdateService updateService;

    public MatchPersistenceServiceImpl(PersistenceService service, PersistenceUpdateService updateService) {
        factory = service.getFactory();
        this.updateService = updateService;
    }

    @Override
    public void create(MatchEntity entity) {
        var session = factory.openSession();
        var transaction = session.beginTransaction();

        session.persist(entity);

        transaction.commit();
        session.close();
    }

    @Override
    public MatchEntity read(UUID id) {
        var session = factory.openSession();
        var transaction = session.beginTransaction();

        var entity = session.createQuery(
                        "from MatchEntity m " +
                                "left join fetch m.horse " +
                                "left join fetch m.bet " +
                                "where m.id =: id",
                        MatchEntity.class)
                .setParameter("id", id)
                .getSingleResult();

        transaction.commit();
        session.close();
        return entity;
    }

    @Override
    public List<MatchEntity> readAll() {
        var session = factory.openSession();
        var transaction = session.beginTransaction();

        List<MatchEntity> resultList = session.createQuery(
                        "from MatchEntity m " +
                                "left join fetch m.horse " +
                                "left join fetch m.bet ",
                        MatchEntity.class)
                .getResultList();

        transaction.commit();
        session.close();
        return resultList;
    }

    @Override
    public void update(MatchEntity entity) {
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

        MatchEntity entity = read(id);
        session.remove(entity);

        transaction.commit();
        session.close();
    }

    @Override
    public void update(MatchEntity entity, String field, Object value) {
        updateService.update(entity, field, value);
    }
}
