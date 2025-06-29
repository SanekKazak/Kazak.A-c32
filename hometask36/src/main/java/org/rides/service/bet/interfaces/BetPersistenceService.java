package org.rides.service.bet.interfaces;

import org.rides.entity.BetEntity;
import java.util.List;
import java.util.UUID;

public interface BetPersistenceService {
    void create(BetEntity entity);
    BetEntity read(String login);
    BetEntity read(UUID id);
    List<BetEntity> readAll();
    void update(BetEntity entity);
    void delete(BetEntity entity);
}
