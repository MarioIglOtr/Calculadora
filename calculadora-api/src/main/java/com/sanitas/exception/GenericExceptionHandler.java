package com.sanitas.exception;

import com.sanitas.domain.exception.OperatorException;
import com.sanitas.domain.utils.Logger;
import io.corp.calculator.TracerAPI;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@NoArgsConstructor
public class GenericExceptionHandler extends RuntimeException {

    private final TracerAPI log = new Logger();

    @ExceptionHandler(OperatorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleNotFoundException(OperatorException ex) {
        if (ex.getMessage() != null) {
            log.trace(ex.getMessage());
        }
        log.trace(ex.getErrorMenssage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrorMenssage());
    }
}
