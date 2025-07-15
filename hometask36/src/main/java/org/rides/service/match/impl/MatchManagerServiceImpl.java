package org.rides.service.match.impl;

import lombok.RequiredArgsConstructor;
import org.rides.entity.MatchEntity;
import org.rides.service.match.interfaces.MatchManagerService;
import org.rides.service.match.interfaces.MatchPersistenceService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatchManagerServiceImpl implements MatchManagerService {
    private final MatchPersistenceService persistenceService;
    @Override
    public Boolean create(MatchEntity entity) {
        persistenceService.create(entity);
        return true;
    }
}
