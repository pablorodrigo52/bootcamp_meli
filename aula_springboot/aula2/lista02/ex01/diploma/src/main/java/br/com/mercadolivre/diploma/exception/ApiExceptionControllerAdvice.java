package br.com.mercadolivre.diploma.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionControllerAdvice extends RuntimeException {
    
    private final MessageSource messageSource;

    @Autowired
    public ApiExceptionControllerAdvice(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ValidationError> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ValidationError> errors = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        fieldErrors.forEach(e -> {
            String message = messageSource.getMessage(e, Locale.ENGLISH);
            errors.add(new ValidationError(e.getField(), message, e.getRejectedValue().toString()));
        });

        return errors;
    }
}
