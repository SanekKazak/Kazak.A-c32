package org.alex.serve.persistence;

import java.util.List;

public interface Persistence<R>{
    void create(R entity);
    boolean isExist(R entity);
    List<R> getAll();
}


