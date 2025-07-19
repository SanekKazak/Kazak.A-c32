package org.rides.handler.match.impl;

import lombok.RequiredArgsConstructor;
import org.rides.handler.match.interfaces.MatchHeldHandler;
import org.rides.service.match.interfaces.MatchHeldService;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MatchHeldHandlerImpl implements MatchHeldHandler {
    private final MatchHeldService heldService;

    @Override
    public Boolean held(UUID id) {
        return heldService.heldMatch(id);
    }
}
