package org.alex.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.alex.entity.Brand;

import java.time.LocalDate;

@Getter @Setter @Builder
public class SearchDto {
    private Brand brand;
    private Integer costFrom;
    private Integer costTo;
    private Integer mileageFrom;
    private Integer mileageTo;
    private LocalDate release;
}
