package org.rides.dto.player;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class PlayerBalanceUpdate {
    private UUID token;
    private Integer delta;
}
