package org.spring.hometask47blhotelcontrol.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.spring.hometask47blhotelcontrol.dto.HotelDto;
import org.spring.hometask47blhotelcontrol.service.HotelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService service;
    private final ObjectMapper mapper;

    @GetMapping
    public List<HotelDto> getAll() {
        return service.getAll();
    }

    @PostMapping
    public HotelDto registerHotel(@Valid @RequestBody HotelDto dto) {
        return service.create(dto);
    }

    @DeleteMapping("/{id}")
    public HotelDto delete(@PathVariable UUID id) {
        return service.delete(id);
    }
}
