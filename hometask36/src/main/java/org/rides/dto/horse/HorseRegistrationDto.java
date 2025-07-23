package org.rides.dto.horse;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HorseRegistrationDto {
    @NotEmpty(message = "name should be not null")
    private String name;
}

