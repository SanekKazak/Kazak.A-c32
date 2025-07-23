package org.rides.handler.bet.interfaces;

import org.rides.dto.bet.BetRegistrationDto;

import java.util.UUID;

public interface BetRegisterHandler {
    Boolean register(BetRegistrationDto dto, UUID token);
}
