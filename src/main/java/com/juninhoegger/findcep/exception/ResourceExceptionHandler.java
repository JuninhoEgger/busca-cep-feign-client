package com.juninhoegger.findcep.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

import static java.lang.System.currentTimeMillis;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.ResponseEntity.status;

@Slf4j
@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(NotFoundException ex, HttpServletRequest request) {
        log.info("Objeto não encontrado");
        StandardError err = new StandardError(currentTimeMillis(), NOT_FOUND.value(), "Não encontrado", ex.getMessage(), request.getRequestURI());
        return status(NOT_FOUND.value()).body(err);
    }

}
