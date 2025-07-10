package org.rides.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HorseDto {
    private UUID id;
    private List<UUID> matchesId;
    private List<UUID> awardsId;
    private Double avgSpeed;
    private String name;
}
