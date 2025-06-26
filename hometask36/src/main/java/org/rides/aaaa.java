package org.rides;

import org.rides.entity.PlayerEntity;
import org.rides.service.player.impl.PlayerPersistenceServiceImpl;
import org.rides.service.player.interfaces.PlayerPersistenceService;

public class aaaa {
    public static void main(String[] args) {
        var service = new PlayerPersistenceServiceImpl();
        var entity = new PlayerEntity("Sanek", "123", 1234);
        service.create(entity);
    }
}
