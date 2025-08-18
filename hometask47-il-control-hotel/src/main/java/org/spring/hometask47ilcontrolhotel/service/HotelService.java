package org.spring.hometask47ilcontrolhotel.service;

import lombok.RequiredArgsConstructor;
import org.spring.hometask47ilcontrolhotel.dto.HotelDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final RestTemplate template;

    public List<HotelDto> getAll(){
        var entity = template.exchange("http://localhost:8081/hotel", HttpMethod.GET, null, HotelDto[].class);
        return Arrays.stream(Objects.requireNonNull(entity.getBody())).toList();
    }
    public HotelDto delete(UUID id){
        HotelDto dto = new HotelDto();
        dto.setId(id);
        HttpEntity<HotelDto> http = new HttpEntity<>(dto);
        var entity = template.exchange("http://localhost:8081/hotel/"+id, HttpMethod.DELETE, http, HotelDto.class);
        return entity.getBody();
    }

    public HotelDto create(HotelDto dto){
        HttpEntity<HotelDto> http = new HttpEntity<>(dto);
        var entity = template.exchange("http://localhost:8081/hotel", HttpMethod.POST, http, HotelDto.class);
        return entity.getBody();
    }
}
