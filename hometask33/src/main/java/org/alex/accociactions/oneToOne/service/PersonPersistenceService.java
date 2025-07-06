package org.alex.accociactions.oneToOne.service;

import org.alex.accociactions.config.SessionPersistence;
import org.alex.accociactions.oneToOne.entity.PersonEntity;

import java.util.UUID;

public class PersonPersistenceService {
    public void save(PersonEntity entity){
        var factory = SessionPersistence.getSession();
        var session = factory.openSession();

        var transaction = session.beginTransaction();

        var home = entity.getHome();
        if(home!=null){
            home.setPerson(entity);
        }
        session.persist(entity);

        transaction.commit();
        session.close();
    }
    public PersonEntity byId(UUID id){
        var factory = SessionPersistence.getSession();
        var session = factory.openSession();
        var transaction = session.beginTransaction();

        var entity = session.find(PersonEntity.class, id);

        transaction.commit();
        session.close();

        return entity;
    }
}
