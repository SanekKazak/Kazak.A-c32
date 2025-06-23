package org.alex;

import org.alex.dto.SearchDto;
import org.alex.entity.Brand;
import org.alex.entity.CarEntity;
import org.alex.service.CarPersistenceService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        var service = new CarPersistenceService();
        var car = new CarEntity(Brand.AUDI, 75, 46552, LocalDate.now());
        SearchDto build = SearchDto.builder()
                .release(LocalDate.of(2025, 05, 28))
                .build();
        System.out.println(service.getByFilter(build));
    }
}
