package org.spring.hometask47ilcontrolhotel.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.hometask47ilcontrolhotel.client.HotelClient;
import org.spring.hometask47ilcontrolhotel.dto.HotelDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HotelService {
    private final Logger logger = LoggerFactory.getLogger("HotelService");

    private final HotelClient client;

    public List<HotelDto> getAll(){
        logger.info("wait for redirect:" + client + " List<HotelDto> getAll()");
        return client.getAll();
    }
    public HotelDto delete(UUID id){
        logger.info("wait for redirect:" + client + " - HotelDto delete(UUID id)");
       return client.delete(id);
    }
    public HotelDto create(HotelDto dto){
        logger.info("wait for redirect:" + client + " - HotelDto create(HotelDto dto)");
        return client.registerHotel(dto);
    }
}
