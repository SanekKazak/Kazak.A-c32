package org.alex.serve.service;

import org.alex.entity.Entity;

public class PersistenceService {
    public <T> boolean isExist(Entity<T> en) {
        return en.getPersistence().isExist((T)en);
    }

    public <T> void create(Entity<T> en) {
        en.getPersistence().create((T)en);
    }
}
