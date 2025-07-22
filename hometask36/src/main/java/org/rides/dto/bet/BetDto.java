package org.rides.dto.bet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.rides.entity.BetEntity;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BetDto {
    private UUID id;
    private UUID horseId;
    private UUID matchId;
    private Integer bet;
    private BetEntity.ResultType result;

    public String getInfo() {
        return " id:" + id + " horseId:" + horseId + " matchId:" + matchId + " bet:" + bet;
    }
}
