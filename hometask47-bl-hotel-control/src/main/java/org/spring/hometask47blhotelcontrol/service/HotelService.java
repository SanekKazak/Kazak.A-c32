package org.spring.hometask47blhotelcontrol.service;

import lombok.RequiredArgsConstructor;
import org.spring.hometask47blhotelcontrol.dto.HotelDto;
import org.spring.hometask47blhotelcontrol.entity.HotelEntity;
import org.spring.hometask47blhotelcontrol.mapper.HotelMapper;
import org.spring.hometask47blhotelcontrol.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepository repository;
    private final HotelMapper mapper;

    public List<HotelDto> getAll(){
        return mapper.toDtos(repository.findAll());
    }

    public HotelDto delete(UUID id){
        HotelEntity hotelEntity = repository.findById(id).get();
        repository.delete(hotelEntity);
        return mapper.toDto(hotelEntity);
    }

    public HotelDto create(HotelDto dto){
        HotelEntity entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }
}
