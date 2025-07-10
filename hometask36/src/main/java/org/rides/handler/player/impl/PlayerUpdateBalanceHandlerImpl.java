package org.rides.handler.player.impl;

import lombok.RequiredArgsConstructor;
import org.rides.dto.PlayerDto;
import org.rides.handler.player.interfaces.PlayerUpdateBalanceHandler;
import org.rides.mapper.player.PlayerMapper;
import org.rides.service.player.interfaces.PlayerBalanceChangeService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerUpdateBalanceHandlerImpl implements PlayerUpdateBalanceHandler {
    private final PlayerBalanceChangeService changerService;
    private final PlayerMapper mapper;
    @Override
    public Boolean updatePlayerBalance(PlayerDto dto, Integer delta) {
        var entity = mapper.toEntity(dto);
        return changerService.changeBalanceValue(entity, delta);
    }
}
