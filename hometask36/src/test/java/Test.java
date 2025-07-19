import org.rides.handler.bet.interfaces.BetRegisterHandler;
import org.rides.handler.horse.interfaces.HorseRegisterHandler;
import org.rides.handler.match.interfaces.MatchHeldHandler;
import org.rides.handler.match.interfaces.MatchRegisterHandler;
import org.rides.handler.player.interfaces.PlayerAuthorizationHandler;
import org.rides.handler.player.interfaces.PlayerRegisterHandler;
import org.rides.handler.player.interfaces.PlayerUpdateBalanceHandler;
import org.rides.service.bet.interfaces.BetPersistenceService;
import org.rides.service.match.interfaces.MatchPersistenceService;
import org.rides.service.player.interfaces.PlayerPersistenceService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.UUID;

public class Test {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext("org.rides");
        HorseRegisterHandler horseReg = context.getBean(HorseRegisterHandler.class);
        BetRegisterHandler betReg = context.getBean(BetRegisterHandler.class);
        MatchRegisterHandler matchReg = context.getBean(MatchRegisterHandler.class);
        MatchPersistenceService matchPer = context.getBean(MatchPersistenceService.class);
        BetPersistenceService betPer = context.getBean(BetPersistenceService.class);
        PlayerPersistenceService playerPer = context.getBean(PlayerPersistenceService.class);
        PlayerRegisterHandler playerReg = context.getBean(PlayerRegisterHandler.class);
        MatchHeldHandler matchHeld = context.getBean(MatchHeldHandler.class);
        PlayerAuthorizationHandler playerAuthorization = context.getBean(PlayerAuthorizationHandler.class);
        PlayerUpdateBalanceHandler playerUpdateBalance = context.getBean(PlayerUpdateBalanceHandler.class);

        matchHeld.held(UUID.fromString("c6073ec8-e849-40af-98b5-fff2d3192b9e"));

//        playerReg.register(new PlayerCredentialsDto("login", "password"));
//        horseReg.register(new HorseRegistrationDto("name"));
//        UUID authorize = playerAuthorization.authorize(new PlayerCredentialsDto("login", "password"));
//        playerUpdateBalance.updatePlayerBalance(new PlayerBalanceUpdate(authorize, 234));
//        List<UUID> horses = new ArrayList<>();
//        horses.add(UUID.fromString("c2066ae4-ab2f-49eb-8ff5-73de9fe7196a"));
//        matchReg.register(new MatchRegistrationDto(horses));
//        betReg.register(new BetRegistrationDto(
//                UUID.fromString("224c42de-2ce7-45db-9be3-6cd05ca96a9e"),
//                UUID.fromString("c2066ae4-ab2f-49eb-8ff5-73de9fe7196a"),
//                UUID.fromString("c6073ec8-e849-40af-98b5-fff2d3192b9e"),
//                42));
        System.out.println();
    }

}
