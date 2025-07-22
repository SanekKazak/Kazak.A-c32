package org.rides.dto.player;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class PlayerCredentialsDto {
    @NotEmpty(message = "login should be not null")
    private String login;
    @NotEmpty(message = "password should be not null")
    private String password;
}
