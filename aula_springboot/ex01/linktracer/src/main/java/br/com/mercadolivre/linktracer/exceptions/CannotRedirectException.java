package br.com.mercadolivre.linktracer.exceptions;

public class CannotRedirectException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public CannotRedirectException(String msg){
        super(msg);
    }
    
}
