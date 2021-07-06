package br.com.mercadolivre.linktracer.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.mercadolivre.linktracer.exceptions.URLIndisponivelException;

@RestControllerAdvice
public class URLIndisponivelHandler {
    
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(URLIndisponivelException.class)
    public ResponseEntity<?> handleUrlIndisponivelException(URLIndisponivelException e){
        return ResponseEntity.notFound().build();
    }
}
