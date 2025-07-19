package org.rides.service.bet.impl;

import org.hibernate.SessionFactory;
import org.rides.entity.HorseEntity;
import org.rides.entity.MatchEntity;
import org.rides.entity.PlayerEntity;
import org.rides.utils.PersistenceService;
import org.rides.entity.BetEntity;
import org.rides.service.bet.interfaces.BetPersistenceService;
import org.rides.utils.PersistenceUpdateService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BetPersistenceServiceImpl implements BetPersistenceService {
    private final SessionFactory factory;
    private final PersistenceUpdateService updateService;

    public BetPersistenceServiceImpl(PersistenceService service, PersistenceUpdateService updateService) {
        factory = service.getFactory();
        this.updateService = updateService;
    }

    @Override
    public void create(BetEntity entity) {
        var session = factory.openSession();
        var transaction = session.beginTransaction();

        Integer balance = entity.getPlayer().getBalance();

        MatchEntity match = session.getReference(MatchEntity.class, entity.getMatch().getId());
        HorseEntity horse = session.getReference(HorseEntity.class, entity.getHorse().getId());
        PlayerEntity player = session.getReference(PlayerEntity.class, entity.getPlayer().getId());

        player.setBet(entity);
        player.setBalance(balance);
        horse.setBet(entity);
        match.setBet(entity);

        session.persist(entity);

        transaction.commit();
        session.close();
    }

    @Override
    public void multiSave(BetEntity entity, List<String> fields) {
        updateService.multiUpdate(entity, fields);
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

        System.out.println();
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

    @Override
    public void update(BetEntity entity, String field, Object value) {
        updateService.update(entity, field, value);
    }
}
