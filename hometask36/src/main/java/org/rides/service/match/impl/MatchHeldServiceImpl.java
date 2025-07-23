package org.rides.service.match.impl;

import lombok.RequiredArgsConstructor;
import org.rides.entity.BetEntity;
import org.rides.entity.HorseEntity;
import org.rides.entity.MatchEntity;
import org.rides.service.bet.interfaces.BetCashFlowService;
import org.rides.service.bet.interfaces.BetPersistenceService;
import org.rides.service.horse.interfaces.HorsePersistenceService;
import org.rides.service.horse.interfaces.HorseRunService;
import org.rides.service.match.interfaces.MatchCalculateWinnerService;
import org.rides.service.match.interfaces.MatchHeldService;
import org.rides.service.match.interfaces.MatchPersistenceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchHeldServiceImpl implements MatchHeldService {
    private final MatchPersistenceService matchPersistenceService;
    private final HorsePersistenceService horsePersistenceService;
    private final BetPersistenceService betPersistenceService;
    private final HorseRunService horseRunService;
    private final MatchCalculateWinnerService winnerService;
    private final BetCashFlowService resultPayService;

    @Override
    public Boolean heldMatch(MatchEntity matchEntity) {
        MatchEntity match = matchPersistenceService.read(matchEntity.getId());
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

        List<BetEntity> readyToSaveBets = betDefiniteType.stream()
                .map(resultPayService::resolveInflow)
                .toList();

        readyToSaveBets.forEach(bet -> betPersistenceService.multiSave(bet, List.of("result")));
        measured.forEach(horse-> horsePersistenceService.update(horse, "avgSpeed", horse.getAvgSpeed()));
        matchPersistenceService.update(calculatedWinner,"winner", calculatedWinner.getWinner());

        return true;
    }
}
