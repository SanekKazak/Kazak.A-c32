package org.rides.dto.player;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerBalanceUpdate {
    @NotNull(message = "delta should be not null")
    @Positive(message = "should be positive value")
    private Integer delta;
}
