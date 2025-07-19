package org.rides.dto.bet;

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
    private UUID token;
    private UUID horseId;
    private UUID matchId;
    private Integer bet;
}

