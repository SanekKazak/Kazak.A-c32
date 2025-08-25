package org.spring.hometask50.web;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.hometask50.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
    private final Logger log = LoggerFactory.getLogger("UserController");

    @GetMapping("/all")
    public String getAll(){
        service.getAll().forEach(w->log.info(w.toString()));
        return "forward:/all.html";
    }
    @GetMapping("/auth")
    public String auth(){
        return "forward:/auth_only.html";
    }
    @GetMapping("/nobody")
    public String nobody(){
        return "forward:/nobody.html";
    }
    @GetMapping("/read")
    public String read(){
        return "forward:/read_only.html";
    }
    @GetMapping("/support")
    public String support(){
        return "forward:/support_only.html";
    }
}
