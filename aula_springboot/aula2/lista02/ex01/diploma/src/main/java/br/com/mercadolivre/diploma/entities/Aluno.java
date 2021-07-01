package br.com.mercadolivre.diploma.entities;

import java.util.List;

/**
 * Aluno
 */
public class Aluno {

    private String name;
    private List<Disciplina> course;
    
    public Aluno() {
    }

    public Aluno(String name, List<Disciplina> course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Disciplina> getCourse() {
        return this.course;
    }

    public void setCourse(List<Disciplina> course) {
        this.course = course;
    }

}
