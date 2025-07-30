package org.web.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.rides.dto.player.PlayerBalanceUpdate;
import org.rides.handler.player.interfaces.PlayerUpdateBalanceHandler;
import org.rides.service.player.interfaces.PlayerAuthService;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/update")
public class UpdateController {
    private final PlayerUpdateBalanceHandler playerUpdateBalanceHandler;
    private final PlayerAuthService playerAuthService;

    @GetMapping(value = "/balance")
    public String matchRegisterPage(
            Model model,
            HttpSession session) {
        var token = (UUID)session.getAttribute("token");
        modelErrorInit(model);
        Integer balance = playerAuthService.findByToken(token).getBalance();
        model.addAttribute("balance", balance);
        model.addAttribute("balanceUpdateDto", new PlayerBalanceUpdate());
        return "balance";
    }

    @PostMapping(value = "/balance")
    public String matchBalancePage(
            @ModelAttribute(name="balanceUpdateDto") @Valid PlayerBalanceUpdate balanceUpdateDto,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            HttpSession session
    ){
        if(session.getAttribute("token")==null){
            return "error";
        }
        Boolean isUpdated;
        if(!bindingResult.hasErrors()) {
            isUpdated = playerUpdateBalanceHandler.updatePlayerBalance(
                    balanceUpdateDto,
                    UUID.fromString(session.getAttribute("token").toString())
            );
        }else{
            redirectAttributes.addFlashAttribute("errors", getErrors(bindingResult));
            return "redirect:/update/balance";
        }
        return isUpdated ? "redirect:/update/balance" : "error";
    }

    private List<String> getErrors(BindingResult bindingResult) {
        return bindingResult.getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();
    }

    private void modelErrorInit(Model model) {
        List<String> errors = (List<String>) model.getAttribute("errors");
        if(errors!=null && !errors.isEmpty()) {
            model.addAttribute("errors", errors);
        }
    }
}
