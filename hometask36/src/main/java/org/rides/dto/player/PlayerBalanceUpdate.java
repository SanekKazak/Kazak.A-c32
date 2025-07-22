package org.rides.dto.player;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerBalanceUpdate {
    @NotEmpty(message = "should be authorize")
    private UUID token;
    @NotEmpty(message = "delta should be not null")
    @Positive(message = "should be positive value")
    private Integer delta;
}
