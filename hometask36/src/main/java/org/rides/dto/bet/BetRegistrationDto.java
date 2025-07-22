package org.rides.dto.bet;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BetRegistrationDto {
    @NotNull(message = "token should be not null")
    private UUID token;
    @NotNull(message = "horse id should be not null")
    private UUID horseId;
    @NotNull(message = "match id should be not null")
    private UUID matchId;
    @NotNull(message = "bet should be not null")
    @Min(value = 20, message = "bet's can not be lower then 20")
    private Integer bet;

    public BetRegistrationDto(UUID horseId, UUID matchId) {
        this.horseId = horseId;
        this.matchId = matchId;
    }
}

