package org.rides.handler.horse.interfaces;

import org.rides.dto.horse.HorseRegistrationDto;

public interface HorseRegisterHandler {
    Boolean register(HorseRegistrationDto dto);
}
