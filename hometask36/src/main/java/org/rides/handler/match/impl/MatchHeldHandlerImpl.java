package org.rides.handler.match.impl;

import lombok.RequiredArgsConstructor;
import org.rides.dto.MatchDto;
import org.rides.entity.MatchEntity;
import org.rides.handler.match.interfaces.MatchHeldHandler;
import org.rides.mapper.match.MatchMapper;
import org.rides.service.match.interfaces.MatchHeldService;

@RequiredArgsConstructor
public class MatchHeldHandlerImpl implements MatchHeldHandler {
    private final MatchHeldService heldService;
    private final MatchMapper mapper;
    @Override
    public Boolean heldMatch(MatchDto dto) {
        MatchEntity entity = mapper.toEntity(dto);
        return heldService.heldMatch(entity);
    }
}
