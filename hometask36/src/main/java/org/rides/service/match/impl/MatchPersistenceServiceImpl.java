package org.rides.service.match.impl;

import org.hibernate.SessionFactory;
import org.rides.entity.HorseEntity;
import org.rides.entity.MatchEntity;
import org.rides.service.match.interfaces.MatchPersistenceService;
import org.rides.utils.PersistenceService;
import org.rides.utils.PersistenceUpdateService;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class MatchPersistenceServiceImpl implements MatchPersistenceService{
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

        List<UUID> listOfId = entity.getHorse().stream()
                .map(HorseEntity::getId)
                .toList();

        List<HorseEntity> horsesById = session.createQuery(
                        "select h " +
                                "from HorseEntity h " +
                                "left join fetch h.match " +
                                "where h.id IN :ids",
                        HorseEntity.class)
                .setParameter("ids", listOfId)
                .getResultList();

        horsesById.forEach(h->h.setMatch(entity));
        entity.setHorse(horsesById);

        session.persist(entity);

        transaction.commit();
        session.close();
    }

    @Override
    public void multiSave(MatchEntity entity, List<String> fields) {
        updateService.multiUpdate(entity.getHorse(), fields);
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
