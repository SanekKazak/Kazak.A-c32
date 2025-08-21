package org.spring.hometask47ilcontrolhotel.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.hometask47ilcontrolhotel.dto.ErrorDto;
import org.spring.hometask47ilcontrolhotel.exception.CommonError;
import org.spring.hometask47ilcontrolhotel.exception.CommonErrors;
import org.spring.hometask47ilcontrolhotel.utils.MassageCache;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionController {
    private final MassageCache cache;
    private final Logger logger = LoggerFactory.getLogger("ExceptionController");

    @ExceptionHandler(CommonError.class)
    public ResponseEntity<List<ErrorDto>> all(CommonError e) {
        ErrorDto errorDto = new ErrorDto(cache.get(e.getCode()), e.getCode());
        logger.warn("expected error processed 500 - " + errorDto);
        return ResponseEntity.status(500).body(List.of(errorDto));
    }

    @ExceptionHandler(CommonErrors.class)
    public ResponseEntity<List<ErrorDto>> all(CommonErrors e) {
        List<ErrorDto> list = e.getCommonErrors().stream()
                .map(exc -> new ErrorDto(cache.get(exc.getCode()), exc.getCode()))
                .toList();
        list.forEach(errorDto->logger.warn("expected error processed 500 - " + errorDto.toString()));
        return ResponseEntity.status(500).body(list);
    }
}
