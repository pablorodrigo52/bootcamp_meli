package br.com.mercadolivre.produtoscrud.service;

public class ProdutoCRUDControllerException extends Exception {

    public static final int PRODUCT_ERROR = 8009;
    public static final int PRODUCT_NOT_EXISTS = 8010;

    public static String errorProduct (String msg){
        return "{'error':"+PRODUCT_ERROR+", 'message':'"+msg+"'}";
    }

    public static String errorProductNotExists(String msg){
        return "{'error':"+PRODUCT_NOT_EXISTS+", 'message':'"+msg+"'}";
    }
    
}
