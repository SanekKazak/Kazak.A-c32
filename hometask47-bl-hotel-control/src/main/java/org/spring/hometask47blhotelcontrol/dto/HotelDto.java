package org.spring.hometask47blhotelcontrol.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
    @Min(message = "808103", value = 2)
    private Integer placeCount;
    @NotBlank(message = "808104")
    private String name;
}
