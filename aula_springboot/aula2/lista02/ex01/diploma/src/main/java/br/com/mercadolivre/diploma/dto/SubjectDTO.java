package br.com.mercadolivre.diploma.dto;

import java.util.List;

public class SubjectDTO {
    
    private double average;
    private String message;
    private List<StudentDTO> student;

    public SubjectDTO (String message){
        this.message = message;
    }

    public SubjectDTO(double average, String message, List<StudentDTO> student) {
        this.average = average;
        this.message = message;
        this.student = student;
    }

    public double getAverage() {
        return this.average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public List<StudentDTO> getStudent() {
        return this.student;
    }

    public void setStudent(List<StudentDTO> student) {
        this.student = student;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "{" +
            "\"message\":\"" + getMessage() + "\"" +
            "}";
    }
   
}
