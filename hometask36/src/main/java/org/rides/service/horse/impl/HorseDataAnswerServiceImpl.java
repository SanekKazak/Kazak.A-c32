package org.rides.service.horse.impl;

import lombok.RequiredArgsConstructor;
import org.rides.dto.horse.HorseDto;
import org.rides.mapper.horse.HorseMapper;
import org.rides.service.horse.interfaces.HorseDataAnswerService;
import org.rides.service.horse.interfaces.HorsePersistenceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HorseDataAnswerServiceImpl implements HorseDataAnswerService {
    private final HorsePersistenceService horsePersistenceService;
    private final HorseMapper horseMapper;
    @Override
    public List<HorseDto> getAll() {
        List<HorseDto> list = horsePersistenceService.readAll().stream()
                .map(horseMapper::toDto)
                .toList();
        return list;
    }
}