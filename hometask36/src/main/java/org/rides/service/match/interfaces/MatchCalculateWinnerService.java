package org.rides.service.match.interfaces;

import org.rides.entity.MatchEntity;

public interface MatchCalculateWinnerService {
    MatchEntity calculateWinner(MatchEntity entity);
}
