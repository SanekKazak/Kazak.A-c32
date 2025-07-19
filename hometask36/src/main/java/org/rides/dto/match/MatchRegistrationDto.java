package org.rides.dto.match;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Setter
@Getter
public class MatchRegistrationDto {
    private List<UUID> horsesId;
}
