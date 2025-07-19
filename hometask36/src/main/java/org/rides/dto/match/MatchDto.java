package org.rides.dto.match;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Setter @Getter
public class MatchDto {
    private UUID id;
    private UUID winnerId;
    private List<UUID> betsId;
    private List<UUID> horsesId;
    private Instant created;
}
