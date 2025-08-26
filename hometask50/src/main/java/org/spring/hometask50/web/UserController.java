package org.spring.hometask50.web;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.hometask50.dto.UserDto;
import org.spring.hometask50.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
    private final Logger log = LoggerFactory.getLogger("UserController");

    @GetMapping("/all")
    public String getAll(){ return "all";}
    @GetMapping("/auth")
    public String auth(){ return "auth_only"; }
    @GetMapping("/nobody")
    public String nobody(){
        return "nobody";
    }
    @GetMapping("/read")
    public String read(){
        return "read_only";
    }
    @GetMapping("/support")
    public String support(){
        return "support_only";
    }
    @GetMapping("/logout")
    public String logout(){
        return "login";
    }
    @GetMapping
    public String login(){
        return "login";
    }
    @GetMapping("/register")
    public String register(){
        return "registration";
    }
    @PostMapping("/register")
    public String register(UserDto dto){
        service.create(dto);
        return "login";
    }
}
