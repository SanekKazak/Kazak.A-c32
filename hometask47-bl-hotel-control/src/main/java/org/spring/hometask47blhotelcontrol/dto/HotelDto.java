package org.spring.hometask47blhotelcontrol.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {
    private UUID id;
    private Integer placeCount;
    private String name;
}
