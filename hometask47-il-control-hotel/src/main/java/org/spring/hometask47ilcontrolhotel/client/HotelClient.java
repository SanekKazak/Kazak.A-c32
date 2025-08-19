package org.spring.hometask47ilcontrolhotel.client;

import org.spring.hometask47ilcontrolhotel.dto.HotelDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "hotel-service", url = "http://localhost:8081/hotel")
public interface HotelClient {
    @GetMapping
    List<HotelDto> getAll();

    @PostMapping
    HotelDto registerHotel(@RequestBody HotelDto dto);

    @DeleteMapping("/{id}")
    HotelDto delete(@PathVariable UUID id);
}
