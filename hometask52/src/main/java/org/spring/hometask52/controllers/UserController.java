package org.spring.hometask52.controllers;

import lombok.RequiredArgsConstructor;
import org.spring.hometask52.dto.UserDto;
import org.spring.hometask52.interfaces.TokenService;
import org.spring.hometask52.services.UserAuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class UserController {
    private final UserAuthService service;
    private final TokenService tokenService;
    @GetMapping("/test1")
    public String test1(){
        return "ok";
    }
    @GetMapping("/test2")
    public String test2(){
        return "ok";
    }
    @PostMapping
    public String login(@RequestBody UserDto dto){
        return service.auth(dto);
    }
}
