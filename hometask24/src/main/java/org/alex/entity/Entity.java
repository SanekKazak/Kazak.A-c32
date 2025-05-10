package org.alex.entity;

import org.alex.serve.persistence.Persistence;

public abstract class Entity<T> {
    protected Persistence<T> persistence;

    public Persistence<T> getPersistence() {
        return persistence;
    }
}