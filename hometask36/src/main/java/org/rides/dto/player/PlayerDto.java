package org.rides.dto.player;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlayerDto {
    private String login;
    private String id;

    public String getInfo(){
        return "login: "+login + " id: "+id;
    }
}
