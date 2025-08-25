package org.spring.hometask47ilcontrolhotel.controller;

import lombok.RequiredArgsConstructor;
import org.spring.hometask47ilcontrolhotel.dto.HotelDto;
import org.spring.hometask47ilcontrolhotel.service.HotelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class MainController {
    private final HotelService service;

    @GetMapping
    public List<HotelDto> getAll() {
        return service.getAll();
    }

    @PostMapping
    public HotelDto registerHotel(@RequestBody HotelDto dto) {
        return service.create(dto);
    }

    @DeleteMapping("/{id}")
    public HotelDto delete(@PathVariable UUID id) {
        return service.delete(id);
    }
}
