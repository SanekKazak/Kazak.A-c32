package org.rides.dto.bet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.rides.entity.BetEntity;

import java.time.Instant;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BetDto {
    private UUID id;
    private UUID playerId;
    private UUID horseId;
    private UUID matchId;
    private Integer bet;
    private Instant created;
    private BetEntity.ResultType result;
}
