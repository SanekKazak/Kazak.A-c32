package org.rides.service.player.impl;

import lombok.RequiredArgsConstructor;
import org.rides.dto.player.PlayerDto;
import org.rides.mapper.player.PlayerMapper;
import org.rides.service.player.interfaces.PlayerDataAnswerService;
import org.rides.service.player.interfaces.PlayerPersistenceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerDataAnswerServiceImpl implements PlayerDataAnswerService {
    private final PlayerPersistenceService playerPersistenceService;
    private final PlayerMapper playerMapper;
    @Override
    public List<PlayerDto> getAll() {
        List<PlayerDto> list = playerPersistenceService.readAll().stream()
                .map(playerMapper::toDto)
                .toList();
        return list;
    }
}
