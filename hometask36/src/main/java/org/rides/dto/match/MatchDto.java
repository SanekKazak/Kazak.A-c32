package org.rides.dto.match;

import lombok.Getter;
import lombok.Setter;
import org.rides.dto.horse.HorseDto;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Setter
@Getter
public class MatchDto {
    private UUID id;
    private UUID winnerId;
    private List<HorseDto> horses;

    public String getInfo() {
        Boolean isPlayed = false;
        if (winnerId != null) {
            isPlayed = true;
        }
        String horsesInfo = horses.stream().map(e -> e.getInfo()).collect(Collectors.joining("\n"));
        return id + " is played:" + isPlayed + " horses:" + horsesInfo;
    }
}
