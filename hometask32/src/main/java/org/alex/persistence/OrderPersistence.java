package org.alex.persistence;

import org.alex.config.SessionFactory;
import org.alex.entity.OrderEntity;

public class OrderPersistence {
    public void create(OrderEntity entity){
        var factory = SessionFactory.getSession();

        var session = factory.openSession();
        var transaction = session.beginTransaction();

        session.persist(entity);

        transaction.commit();
        session.close();
    }
}
