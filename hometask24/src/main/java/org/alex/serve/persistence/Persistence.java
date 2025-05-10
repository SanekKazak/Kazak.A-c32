package org.alex.serve.persistence;

import org.alex.entity.Entity;

public interface Persistence<R>{
    void create(R entity);
    boolean isExist(R entity);
}


