package org.spring.hometask47ilcontrolhotel.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.hometask47ilcontrolhotel.dto.HotelDto;
import org.spring.hometask47ilcontrolhotel.service.HotelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController implements UiHotelController {
    private final HotelService service;
    private final Logger logger = LoggerFactory.getLogger("HotelController");

    @GetMapping
    public List<HotelDto> getAll() {
        logger.info("get request on port 8080 ");
        return service.getAll();
    }

    @PostMapping
    public HotelDto create(@RequestBody HotelDto dto) {
        logger.info("post request on port 8080 with dto " + dto);
        return service.create(dto);
    }

    @DeleteMapping("/{id}")
    public HotelDto delete(@PathVariable UUID id) {
        logger.info("delete request on port 8080 with id " + id);
        return service.delete(id);
    }
}
