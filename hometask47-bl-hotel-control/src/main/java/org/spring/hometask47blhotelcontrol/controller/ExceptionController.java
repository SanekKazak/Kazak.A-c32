package org.spring.hometask47blhotelcontrol.controller;

import org.spring.hometask47blhotelcontrol.dto.ErrorDto;
import org.spring.hometask47blhotelcontrol.exception.CommonError;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(CommonError.class)
    public ResponseEntity<List<ErrorDto>> all(CommonError e) {
        return ResponseEntity.status(500).body(List.of(new ErrorDto(e.getCode())));
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<List<ErrorDto>> all(BindException e) {
        List<ErrorDto> list = e.getBindingResult().getAllErrors().stream()
                .map(exc -> new ErrorDto(exc.getDefaultMessage()))
                .toList();
        return ResponseEntity.status(500).body(list);
    }
}

