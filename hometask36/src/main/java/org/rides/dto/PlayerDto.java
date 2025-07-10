package org.rides.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.rides.entity.PlayerEntity;

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
    private UUID token;
    private List<UUID> betsId;
    private PlayerEntity.RoleType role;
    private Integer balance;
    private Instant registrationTime;
}
