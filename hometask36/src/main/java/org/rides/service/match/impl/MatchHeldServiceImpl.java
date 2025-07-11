package org.rides.service.match.impl;

import lombok.RequiredArgsConstructor;
import org.rides.entity.BetEntity;
import org.rides.entity.HorseEntity;
import org.rides.entity.MatchEntity;
import org.rides.service.bet.interfaces.BetResultPayService;
import org.rides.service.horse.interfaces.HorseRunService;
import org.rides.service.match.interfaces.MatchCalculateWinnerService;
import org.rides.service.match.interfaces.MatchHeldService;
import org.rides.service.match.interfaces.MatchPersistenceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchHeldServiceImpl implements MatchHeldService {
    private final MatchPersistenceService persistenceService;
    private final HorseRunService horseRunService;
    private final MatchCalculateWinnerService winnerService;
    private final BetResultPayService resultPayService;

    @Override
    public Boolean heldMatch(MatchEntity match) {
        List<HorseEntity> measured = horseRunService.measureHorsesSpeed(match.getHorse());
        match.setHorse(measured);

        MatchEntity calculatedWinner = winnerService.calculateWinner(match);

        List<BetEntity> betDefiniteType = calculatedWinner.getBet().stream()
                .peek(bet -> {
                    if(bet.getHorse().equals(match.getWinner())){
                        bet.setResult(BetEntity.ResultType.WIN);
                    }else{
                        bet.setResult(BetEntity.ResultType.LOSE);
                    }
                })
                .toList();

        betDefiniteType.forEach(resultPayService::resolveResult);

        persistenceService.update(match, "bet", betDefiniteType);

        return true;
    }

}
