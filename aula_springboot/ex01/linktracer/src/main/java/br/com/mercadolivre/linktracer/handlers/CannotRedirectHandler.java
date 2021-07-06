package br.com.mercadolivre.linktracer.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.mercadolivre.linktracer.exceptions.CannotRedirectException;

@RestControllerAdvice
public class CannotRedirectHandler {
    
    @ResponseStatus(code = HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(CannotRedirectException.class)
    public ResponseEntity<?> handleCannotRedirectException(CannotRedirectException e){
        return ResponseEntity.notFound().build();
    }
}
