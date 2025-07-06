package org.alex.accociactions.manyToMany.service;

import org.alex.accociactions.config.SessionPersistence;
import org.alex.accociactions.manyToMany.entity.ProviderEntity;

import java.util.List;
import java.util.UUID;

public class ProviderPersistenceService {

    public void save(ProviderEntity providerEntity){
        var factory = SessionPersistence.getSession();
        var session = factory.openSession();
        var transaction = session.beginTransaction();

        session.persist(providerEntity);

        transaction.commit();
        session.close();
    }

    public void save(List<ProviderEntity> providers){
        var factory = SessionPersistence.getSession();
        var session = factory.openSession();
        var transaction = session.beginTransaction();

        providers.forEach(session::persist);

        transaction.commit();
        session.close();
    }

    public ProviderEntity byId(UUID id){
        var factory = SessionPersistence.getSession();
        var session = factory.openSession();
        var transaction = session.beginTransaction();

        var entity = session.find(ProviderEntity.class, id);

        transaction.commit();
        session.close();

        return entity;
    }
}
