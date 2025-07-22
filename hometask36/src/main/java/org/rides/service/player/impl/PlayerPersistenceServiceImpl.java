package org.rides.service.player.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.rides.entity.PlayerEntity;
import org.rides.service.player.interfaces.PlayerPersistenceService;
import org.rides.utils.PersistenceService;
import org.rides.utils.PersistenceUpdateService;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class PlayerPersistenceServiceImpl implements PlayerPersistenceService {
    private final SessionFactory factory;
    private final PersistenceUpdateService updateService;

    public PlayerPersistenceServiceImpl(PersistenceService service, PersistenceUpdateService updateService) {
        factory = service.getFactory();
        this.updateService = updateService;
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
    public PlayerEntity readByLogin(String login) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();

            var entity = session.createQuery(
                            "from PlayerEntity p " +
                                    "left join fetch p.bet b " +
                                    "left join fetch b.horse " +
                                    "where p.login = :login ",
                            PlayerEntity.class)
                    .setParameter("login", login)
                    .getSingleResult();

            transaction.commit();
            return entity;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public PlayerEntity readById(UUID id) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();

            var entity = session.createQuery(
                            "from PlayerEntity p " +
                                    "left join fetch p.bet b " +
                                    "left join fetch b.horse " +
                                    "where p.id =: id",
                            PlayerEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();

            transaction.commit();
            return entity;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public PlayerEntity readByToken(UUID token) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();

            var entity = session.createQuery(
                            "from PlayerEntity " +
                                    "where token = :token ",
                            PlayerEntity.class)
                    .setParameter("token", token)
                    .getSingleResult();

            transaction.commit();
            return entity;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<PlayerEntity> readAll() {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();

            var entities = session.createQuery(
                            "from PlayerEntity p " +
                                    "left join fetch p.bet b " +
                                    "left join fetch b.horse",
                            PlayerEntity.class)
                    .getResultList();

            transaction.commit();
            return entities;
        } catch (Exception e) {
            return null;
        }
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

        PlayerEntity entity = readById(id);
        session.remove(entity);

        transaction.commit();
        session.close();
    }

    @Override
    public void update(PlayerEntity entity, String field, Object value) {
        updateService.update(entity, field, value);
    }
}
