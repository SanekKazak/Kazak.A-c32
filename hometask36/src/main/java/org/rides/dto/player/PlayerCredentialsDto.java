package org.rides.dto.player;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class PlayerCredentialsDto {
    private String login;
    private String password;
}
