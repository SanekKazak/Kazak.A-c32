package org.rides.service.bet.impl;

import lombok.RequiredArgsConstructor;
import org.rides.entity.BetEntity;
import org.rides.service.bet.interfaces.BetResultService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BetResultServiceImpl implements BetResultService {
    private final BetPersistenceServiceImpl betPersistenceService;
    @Override
    public Boolean resloveResult(UUID id) {
        BetEntity entity = betPersistenceService.read(id);
        return null;
    }
}
