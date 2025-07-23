package org.rides.handler.match.impl;

import lombok.RequiredArgsConstructor;
import org.rides.dto.match.MatchHeldDto;
import org.rides.entity.MatchEntity;
import org.rides.handler.match.interfaces.MatchHeldHandler;
import org.rides.mapper.match.MatchHeldMapper;
import org.rides.service.match.interfaces.MatchHeldService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatchHeldHandlerImpl implements MatchHeldHandler {
    private final MatchHeldService heldService;
    private final MatchHeldMapper mapper;

    @Override
    public Boolean held(MatchHeldDto matchHeldDto) {
        MatchEntity entity = mapper.toEntity(matchHeldDto);
        return heldService.heldMatch(entity);
    }
}
