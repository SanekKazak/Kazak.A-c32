package org.rides.service.bet.impl;

import lombok.RequiredArgsConstructor;
import org.rides.dto.PaginationDto;
import org.rides.entity.BetEntity;
import org.rides.service.bet.interfaces.BetInfoService;
import org.rides.service.bet.interfaces.BetPersistenceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BetInfoServiceImpl implements BetInfoService {
    private final BetPersistenceService persistenceService;
    @Override
    public List<BetEntity> getAll(PaginationDto dto) {

        return persistenceService.readAll();
    }
}
