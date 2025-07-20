package org.web.controller;

import lombok.RequiredArgsConstructor;
import org.rides.dto.bet.BetRegistrationDto;
import org.rides.dto.horse.HorseRegistrationDto;
import org.rides.dto.match.MatchRegistrationDto;
import org.rides.dto.player.PlayerCredentialsDto;
import org.rides.handler.bet.interfaces.BetRegisterHandler;
import org.rides.handler.horse.interfaces.HorseRegisterHandler;
import org.rides.handler.match.interfaces.MatchRegisterHandler;
import org.rides.handler.player.interfaces.PlayerRegisterHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegistrationController {
    private final PlayerRegisterHandler playerRegisterHandler;
    private final MatchRegisterHandler matchRegisterHandler;
    private final BetRegisterHandler betRegisterHandler;
    private final HorseRegisterHandler horseRegisterHandler;

    @GetMapping(value = "/player")
    public String playerRegisterPage() {
        return "playerRegister";
    }

    @GetMapping(value = "/horse")
    public String horseRegisterPage() {
        return "horseRegister";
    }

    @GetMapping(value = "/bet")
    public String betRegisterPage() {
        return "betRegister";
    }

    @GetMapping(value = "/match")
    public String matchRegisterPage() {
        return "matchRegister";
    }

    @PostMapping(value = "/player")
    public String playerRegisterPage(PlayerCredentialsDto playerCredentialsDto) {
        Boolean isRegistered = playerRegisterHandler.register(playerCredentialsDto);
        if (isRegistered) {
            return "list";
        }
        return "error";
    }

    @PostMapping(value = "/horse")
    public String horseRegisterPage(HorseRegistrationDto horseRegistrationDto) {
        Boolean isRegistered = horseRegisterHandler.register(horseRegistrationDto);
        if (isRegistered) {
            return "list";
        }
        return "error";
    }

    @PostMapping(value = "/bet")
    public String betRegisterPage(BetRegistrationDto betRegistrationDto) {
        Boolean isRegistered = betRegisterHandler.register(betRegistrationDto);
        if (isRegistered) {
            return "list";
        }
        return "error";
    }

    @PostMapping(value = "/match")
    public String matchRegisterPage(MatchRegistrationDto matchRegistrationDto) {
        Boolean isRegistered = matchRegisterHandler.register(matchRegistrationDto);
        if (isRegistered) {
            return "list";
        }
        return "error";
    }
}
