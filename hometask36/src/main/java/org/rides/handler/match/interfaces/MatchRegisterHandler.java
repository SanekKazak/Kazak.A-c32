package org.rides.handler.match.interfaces;

import org.rides.dto.match.MatchRegistrationDto;

public interface MatchRegisterHandler {
    Boolean register(MatchRegistrationDto dto);
}
