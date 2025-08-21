package org.spring.hometask47ilcontrolhotel.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {
    @Schema(description = "entity id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private UUID id;
    @Schema(description = "count free space in hotel", requiredMode = Schema.RequiredMode.REQUIRED, minimum = "2", maximum = "10")
    private Integer placeCount;
    @Schema(description = "hotel title", requiredMode = Schema.RequiredMode.REQUIRED, example = "Hotel-Eleon")
    private String name;
}
