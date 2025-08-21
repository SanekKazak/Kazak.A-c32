package org.spring.hometask47blhotelcontrol.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.hometask47blhotelcontrol.dto.ErrorDto;
import org.spring.hometask47blhotelcontrol.exception.CommonError;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ExceptionController {
    private final Logger logger = LoggerFactory.getLogger("ExceptionController");

    @ExceptionHandler(CommonError.class)
    public ResponseEntity<List<ErrorDto>> all(CommonError e) {
        ErrorDto errorDto = new ErrorDto(e.getCode());
        logger.warn("process 500 response details: " + errorDto);
        return ResponseEntity.status(500).body(List.of(errorDto));
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<List<ErrorDto>> all(BindException e) {
        List<ErrorDto> list = e.getBindingResult().getAllErrors().stream()
                .map(exc -> new ErrorDto(exc.getDefaultMessage()))
                .toList();
        list.forEach(error-> logger.warn("process 500 response details: " + error.toString()));
        return ResponseEntity.status(500).body(list);
    }
}

