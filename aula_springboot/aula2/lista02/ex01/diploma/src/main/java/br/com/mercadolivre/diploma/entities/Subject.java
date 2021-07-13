package br.com.mercadolivre.diploma.entities;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Subject {

    @NotBlank
    @Size(min = 5, max = 50)
    @Pattern(regexp = "^[A-Za-z_áíó]*$")
    private String subject;

    @NotNull
    @Min(value = 0)
    @Max(value = 99)
    private double note;

    public Subject() {
    }

    public Subject(String subject, double note) {
        this.subject = subject;
        this.note = note;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getNote() {
        return this.note;
    }

    public void setNote(double note) {
        this.note = note;
    }

}
