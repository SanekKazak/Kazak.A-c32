package org.rides.dto.horse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HorseDto {
    private UUID id;
    private Double avgSpeed;
    private String name;
    public String getInfo(){
        return id+" speed:"+avgSpeed+" name:"+name;
    }
}
