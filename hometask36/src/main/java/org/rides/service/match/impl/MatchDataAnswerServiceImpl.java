package org.rides.service.match.impl;

import lombok.RequiredArgsConstructor;
import org.rides.dto.match.MatchDto;
import org.rides.mapper.match.MatchMapper;
import org.rides.service.match.interfaces.MatchDataAnswerService;
import org.rides.service.match.interfaces.MatchPersistenceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchDataAnswerServiceImpl implements MatchDataAnswerService {
    private final MatchPersistenceService matchPersistenceService;
    private final MatchMapper matchMapper;
    @Override
    public List<MatchDto> getAll() {
        List<MatchDto> list = matchPersistenceService.readAll().stream()
                .map(matchMapper::toDto)
                .toList();
        return list;
    }
}
