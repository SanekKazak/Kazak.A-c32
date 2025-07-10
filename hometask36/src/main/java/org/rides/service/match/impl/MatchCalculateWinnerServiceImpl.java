package org.rides.service.match.impl;

import org.rides.entity.HorseEntity;
import org.rides.entity.MatchEntity;
import org.rides.service.match.interfaces.MatchCalculateWinnerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchCalculateWinnerServiceImpl implements MatchCalculateWinnerService {

    @Override
    public MatchEntity calculateWinner(MatchEntity entity) {
        List<HorseEntity> horses = entity.getHorse();

        Optional<HorseEntity> max = horses.stream()
                .max((horse1, horse2) -> (int) (horse1.getAvgSpeed() - horse2.getAvgSpeed()));
        if(max.isEmpty()){
            return null;
        }

        HorseEntity winner = max.get();
        entity.setWinner(winner);
        return entity;
    }
}
