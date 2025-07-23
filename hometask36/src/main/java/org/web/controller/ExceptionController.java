package org.web.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(Exception.class)
    public String handleError(Model model, Exception e){
        model.addAttribute("error", e.getMessage());
        return "error";
    }
}
