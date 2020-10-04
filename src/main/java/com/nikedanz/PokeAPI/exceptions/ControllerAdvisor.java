package com.nikedanz.PokeAPI.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PokemonNotFound.class)
    public ResponseEntity<Object> handlePokemonNotFoundException(PokemonNotFound pkmnNF, WebRequest wr) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", "Pokemon not found");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({InternalError.class, RuntimeException.class, IOException.class})
    public ResponseEntity<Object> handle500(InternalError ie, WebRequest wr) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", "An error has ocurred");

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
