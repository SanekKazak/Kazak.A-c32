package org.spring.hometask47ilcontrolhotel.controller;

import lombok.RequiredArgsConstructor;
import org.spring.hometask47ilcontrolhotel.exception.CommonError;
import org.spring.hometask47ilcontrolhotel.utils.MassageCache;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionController {
    private final MassageCache cache;

    @ExceptionHandler(CommonError.class)
    public ResponseEntity<List<String>> all(CommonError e) {
        if(e.getCommonErrors()!=null){
            List<String> list = e.getCommonErrors().stream()
                    .map(exc -> cache.get(exc.getCode()))
                    .toList();

            return ResponseEntity.status(500).body(list);
        }
        return ResponseEntity.status(500).body(List.of(e.getCode()));
    }
}
