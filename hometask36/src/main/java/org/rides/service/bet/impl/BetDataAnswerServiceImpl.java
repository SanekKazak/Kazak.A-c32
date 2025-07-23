package org.rides.service.bet.impl;

import lombok.RequiredArgsConstructor;
import org.rides.dto.bet.BetDto;
import org.rides.mapper.bet.BetMapper;
import org.rides.service.bet.interfaces.BetDataAnswerService;
import org.rides.service.bet.interfaces.BetPersistenceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BetDataAnswerServiceImpl implements BetDataAnswerService {
    private final BetPersistenceService betPersistenceService;
    private final BetMapper betMapper;
    @Override
    public List<BetDto> getAll() {
        List<BetDto> list = betPersistenceService.readAll().stream()
                .map(betMapper::toDto)
                .toList();
        return list;
    }
}
