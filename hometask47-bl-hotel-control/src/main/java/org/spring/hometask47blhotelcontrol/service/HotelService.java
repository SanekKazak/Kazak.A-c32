package org.spring.hometask47blhotelcontrol.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger logger = LoggerFactory.getLogger("HotelService");

    public List<HotelDto> getAll(){
        List<HotelEntity> all = repository.findAll();
        if(all.isEmpty()){
            throw new CommonError("8081002");
        }
        logger.info("method getAll() worked good");
        return mapper.toDtos(all);
    }

    public HotelDto delete(UUID id){
        Optional<HotelEntity> byId = repository.findById(id);
        if(byId.isEmpty()){
            throw new CommonError("808101");
        }
        HotelEntity hotelEntity = byId.get();
        repository.delete(hotelEntity);
        logger.info("method delete(UUID id) worked good");
        return mapper.toDto(hotelEntity);
    }

    public HotelDto create(HotelDto dto){
        HotelEntity entity = mapper.toEntity(dto);
        logger.info("method create(HotelDto dto) worked good");
        return mapper.toDto(repository.save(entity));
    }
}
