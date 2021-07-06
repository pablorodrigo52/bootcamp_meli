package br.com.mercadolivre.linktracer.exceptions;

public class URLIndisponivelException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public URLIndisponivelException(String msg){
        super(msg);
    }
    
}
