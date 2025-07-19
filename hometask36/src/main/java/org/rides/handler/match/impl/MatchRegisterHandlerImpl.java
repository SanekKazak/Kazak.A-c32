package org.rides.handler.match.impl;

import lombok.RequiredArgsConstructor;
import org.rides.dto.match.MatchRegistrationDto;
import org.rides.entity.MatchEntity;
import org.rides.handler.match.interfaces.MatchRegisterHandler;
import org.rides.mapper.match.MatchRegistrationMapper;
import org.rides.service.match.interfaces.MatchManagerService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatchRegisterHandlerImpl implements MatchRegisterHandler {
    private final MatchManagerService managerService;
    private final MatchRegistrationMapper mapper;

    @Override
    public Boolean register(MatchRegistrationDto dto) {
        MatchEntity entity = mapper.toEntity(dto);
        return managerService.create(entity);
    }
}
