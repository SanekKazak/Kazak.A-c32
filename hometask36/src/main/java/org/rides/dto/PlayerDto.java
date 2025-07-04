package org.rides.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlayerDto {
    private UUID id;
    private String login;
    private List<UUID> bets;
    private Integer balance;
    private Instant registrationTime;
}
