package org.web.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.rides.dto.match.MatchDto;
import org.rides.dto.match.MatchHeldDto;
import org.rides.dto.player.PlayerCredentialsDto;
import org.rides.entity.PlayerEntity;
import org.rides.handler.match.interfaces.MatchHeldHandler;
import org.rides.handler.player.interfaces.PlayerAuthorizationHandler;
import org.rides.service.match.interfaces.MatchDataAnswerService;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@SessionAttributes("token")
public class FunctionalController {
    private final PlayerAuthorizationHandler playerAuthorizationHandler;
    private final MatchHeldHandler matchHeldHandler;
    private final MatchDataAnswerService  matchDataAnswerService;

    @GetMapping(value = "/auth")
    public String auth(Model model) {
        modelSetError(model);
        model.addAttribute("playerCredentialsDto", new PlayerCredentialsDto());
        return "auth";
    }

    @GetMapping(value = "/held")
    public String held(Model model) {
        List<MatchDto> all = matchDataAnswerService.getAll();
        List<MatchDto> necessary = all.stream()
                .filter(e -> e.getWinnerId() == null)
                .toList();
        modelSetError(model);
        model.addAttribute("matchHeldDto", new MatchHeldDto());
        model.addAttribute("matches", necessary);
        return "held";
    }

    @PostMapping(value = "/auth")
    public String auth(
            @Valid @ModelAttribute(name = "playerCredentialsDto") PlayerCredentialsDto dto,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            HttpSession session
    ) {
        UUID token = null;

        if(session.getAttribute("token") != null) {
            return "redirect:/update/balance";
        }

        if(!bindingResult.hasErrors()) {
            PlayerEntity playerFromToken = playerAuthorizationHandler.authorize(dto);
            var role = playerFromToken.getRole();
            token = playerFromToken.getToken();
            session.setAttribute("token", token);
            session.setAttribute("role", role);

        }else{
            redirectAttributes.addFlashAttribute("errors", getError(bindingResult));
        }

        if(token==null) {
            return "redirect:/auth";
        }
        return "redirect:/update/balance";
    }

    @PostMapping(value = "/held")
    public String held(
            @Valid @ModelAttribute(name = "matchHeldDto") MatchHeldDto dto,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        Boolean isHelded = false;

        if(!bindingResult.hasErrors()) {
            isHelded = matchHeldHandler.held(dto);
        }else{
            redirectAttributes.addFlashAttribute("errors", getError(bindingResult));
        }

        return isHelded ? "redirect:/register/bet" : "error";
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
