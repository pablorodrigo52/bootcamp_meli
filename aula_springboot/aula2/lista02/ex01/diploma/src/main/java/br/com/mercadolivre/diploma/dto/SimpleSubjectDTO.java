package br.com.mercadolivre.diploma.dto;

import java.util.List;

public class SimpleSubjectDTO {
    
    private double average;
    private String message;

    public SimpleSubjectDTO (String message){
        this.message = message;
    }

    public SimpleSubjectDTO(double average, String message) {
        this.average = average;
        this.message = message;
    }

    public double getAverage() {
        return this.average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }   
}
