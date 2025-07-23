package org.rides.dto.match;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MatchRegistrationDto {
    @NotEmpty(message = "horse id should be not null")
    @Size(min=2, message = "horse should be more than 2")
    private List<UUID> horsesId;
}
