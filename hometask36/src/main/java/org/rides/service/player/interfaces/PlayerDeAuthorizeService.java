package org.rides.service.player.interfaces;

import org.rides.entity.PlayerEntity;

public interface PlayerDeAuthorizeService {
    Boolean deAuthorize(PlayerEntity entity);
}
