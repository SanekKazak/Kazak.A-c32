package org.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.rides.dto.bet.BetRegistrationDto;
import org.rides.dto.horse.HorseRegistrationDto;
import org.rides.dto.match.MatchRegistrationDto;
import org.rides.dto.player.PlayerCredentialsDto;
import org.rides.handler.bet.interfaces.BetRegisterHandler;
import org.rides.handler.horse.interfaces.HorseRegisterHandler;
import org.rides.handler.match.interfaces.MatchRegisterHandler;
import org.rides.handler.player.interfaces.PlayerRegisterHandler;
import org.rides.service.bet.interfaces.BetDataAnswerService;
import org.rides.service.horse.interfaces.HorseDataAnswerService;
import org.rides.service.match.interfaces.MatchDataAnswerService;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegistrationController {
    private final PlayerRegisterHandler playerRegisterHandler;
    private final MatchRegisterHandler matchRegisterHandler;
    private final BetRegisterHandler betRegisterHandler;
    private final HorseRegisterHandler horseRegisterHandler;
    private final HorseDataAnswerService horseDataAnswerService;
    private final BetDataAnswerService betDataAnswerService;
    private final MatchDataAnswerService matchDataAnswerService;

    @GetMapping(value = "/player")
    public String playerRegisterPage(Model model){
        modelSetError(model);
        model.addAttribute("playerCredentialsDto", new PlayerCredentialsDto());
        return "playerRegister";
    }

    @PostMapping(value = "/player")
    public String playerRegisterPage(
            @ModelAttribute("playerCredentialsDto") @Valid PlayerCredentialsDto playerCredentialsDto,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        Boolean isRegistered;

        if(!bindingResult.hasErrors()) {
            isRegistered = playerRegisterHandler.register(playerCredentialsDto);
        }else{
            redirectAttributes.addFlashAttribute("errors", getError(bindingResult));
            return "redirect:/register/player";
        }

        return isRegistered ? "redirect:/register/player" : "error";
    }

    @GetMapping(value = "/bet")
    public String betRegisterPage(Model model) {
        modelSetError(model);
        model.addAttribute("matches", matchDataAnswerService.getAll());
        model.addAttribute("horses", horseDataAnswerService.getAll());
        model.addAttribute("betRegistrationDto", new BetRegistrationDto());
        return "betRegister";
    }

    @PostMapping(value = "/bet")
    public String betRegisterPage(
            @ModelAttribute("betRegistrationDto") @Valid BetRegistrationDto betRegistrationDto,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            HttpSession session
    ) {
        UUID token = (UUID)session.getAttribute("token");
        if(token == null){
            return "error";
        }

        Boolean isRegistered;

        if(!bindingResult.hasErrors()) {
            isRegistered = betRegisterHandler.register(betRegistrationDto, token);
        }else{
            redirectAttributes.addFlashAttribute("errors", getError(bindingResult));
            return "redirect:/register/bet";
        }

        return isRegistered ? "redirect:/register/bet" : "error";
    }

    @GetMapping(value = "/horse")
    public String horseRegisterPage(Model model) {
        modelSetError(model);
        model.addAttribute("horseRegistrationDto", new HorseRegistrationDto());
        return "horseRegister";
    }

    @PostMapping(value = "/horse")
    public String horseRegisterPage(
            @ModelAttribute("horseRegistrationDto") @Valid HorseRegistrationDto horseRegistrationDto,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        Boolean isRegistered;

        if(!bindingResult.hasErrors()) {
            isRegistered = horseRegisterHandler.register(horseRegistrationDto);
        }else{
            redirectAttributes.addFlashAttribute("errors", getError(bindingResult));
            return "redirect:/register/horse";
        }
        return isRegistered ? "redirect:/register/horse" : "error";
    }

    @GetMapping(value = "/match")
    public String matchRegisterPage(Model model) {
        model.addAttribute("horses", horseDataAnswerService.getAll());
        modelSetError(model);
        model.addAttribute("matchRegistrationDto", new MatchRegistrationDto(new ArrayList<>()));
        return "matchRegister";
    }

    @PostMapping(value = "/match")
    public String matchRegisterPage(
            @ModelAttribute("matchRegistrationDto") @Valid MatchRegistrationDto matchRegistrationDto,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            HttpServletRequest request
    ) {
        Boolean isRegistered;

        if(!bindingResult.hasErrors()) {
            isRegistered = matchRegisterHandler.register(matchRegistrationDto);
        }else{
            redirectAttributes.addFlashAttribute("errors", getError(bindingResult));
            return "redirect:/register/match";
        }
        return isRegistered ? "redirect:/register/match" : "error";
    }

    private List<String> getError(BindingResult bindingResult) {
        return bindingResult.getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();
    }
    private void modelSetError(Model model){
        List<String> errors = (List<String>) model.getAttribute("errors");
        if(errors!=null && !errors.isEmpty()) {
            model.addAttribute("errors", errors);
        }
    }
}
