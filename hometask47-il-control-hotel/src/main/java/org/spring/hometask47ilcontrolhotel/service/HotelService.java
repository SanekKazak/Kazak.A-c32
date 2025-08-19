package org.spring.hometask47ilcontrolhotel.service;

import lombok.RequiredArgsConstructor;
import org.spring.hometask47ilcontrolhotel.client.HotelClient;
import org.spring.hometask47ilcontrolhotel.dto.HotelDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelClient client;

    public List<HotelDto> getAll(){
        return client.getAll();
    }
    public HotelDto delete(UUID id){
       return client.delete(id);
    }

    public HotelDto create(HotelDto dto){
        return client.registerHotel(dto);
    }
}
