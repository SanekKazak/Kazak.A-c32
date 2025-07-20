package org.web.controller;

import lombok.RequiredArgsConstructor;
import org.rides.handler.match.interfaces.MatchHeldHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final MatchHeldHandler matchHeldHandler;

    @GetMapping(value = {"/list", "/"})
    public String mainPage(){
        return "list";
    }

    @GetMapping(value = "/auth")
    public String playerAuthPage(){
        return "auth";
    }

    @GetMapping(value = "/held")
    public String matchHeldPage(){
        return "matchHelder";
    }

    @PostMapping(value = "/held")
    public String matchHeldPage(
            @RequestParam(name = "match_id")UUID id
    ){
        matchHeldHandler.held(id);
        return "list";
    }
}
