package org.spring.hometask47blhotelcontrol.service;

import lombok.RequiredArgsConstructor;
import org.spring.hometask47blhotelcontrol.dto.HotelDto;
import org.spring.hometask47blhotelcontrol.entity.HotelEntity;
import org.spring.hometask47blhotelcontrol.exception.CommonError;
import org.spring.hometask47blhotelcontrol.mapper.HotelMapper;
import org.spring.hometask47blhotelcontrol.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepository repository;
    private final HotelMapper mapper;

    public List<HotelDto> getAll(){
        List<HotelEntity> all = repository.findAll();
        if(all.isEmpty()){
            throw new CommonError("8081002");
        }
        return mapper.toDtos(all);
    }

    public HotelDto delete(UUID id){
        Optional<HotelEntity> byId = repository.findById(id);
        if(byId.isEmpty()){
            throw new CommonError("808101");
        }
        HotelEntity hotelEntity = byId.get();
        repository.delete(hotelEntity);
        return mapper.toDto(hotelEntity);
    }

    public HotelDto create(HotelDto dto){
        HotelEntity entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }
}
