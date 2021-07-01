package br.com.mercadolivre.diploma.entities;

public class Disciplina {

    private String name;
    private double grade;

    public Disciplina() {
    }

    public Disciplina(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return this.grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

}
