package org.rides.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PlayerBalanceUpdate {
    private UUID token;
    private Integer delta;
}
