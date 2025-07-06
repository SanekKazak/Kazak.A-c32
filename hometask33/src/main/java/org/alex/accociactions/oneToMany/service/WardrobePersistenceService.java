package org.alex.accociactions.oneToMany.service;

import org.alex.accociactions.config.SessionPersistence;
import org.alex.accociactions.oneToMany.entity.WardrobeEntity;

import java.util.UUID;

public class WardrobePersistenceService {
    public void save(WardrobeEntity wardrobeEntity){
        var factory = SessionPersistence.getSession();
        var session = factory.openSession();
        var transaction = session.beginTransaction();

        session.persist(wardrobeEntity);

        transaction.commit();
        session.close();
    }

    public WardrobeEntity byId(UUID id){
        var factory = SessionPersistence.getSession();
        var session = factory.openSession();
        var transaction = session.beginTransaction();

        var entity = session.find(WardrobeEntity.class, id);

        transaction.commit();
        session.close();

        return entity;
    }
}
