package org.spring.hometask47blhotelcontrol.controller;

import org.spring.hometask47blhotelcontrol.dto.ExceptionDataDto;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public ExceptionDataDto all(Exception e){
        return new ExceptionDataDto(e.getMessage());
    }
}
