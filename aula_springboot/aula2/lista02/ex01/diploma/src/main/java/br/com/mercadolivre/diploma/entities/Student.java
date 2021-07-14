package br.com.mercadolivre.diploma.entities;

import java.util.List;

/**
 * Aluno
 */
public class Student {

    private String name;
    private List<Subject> subjects;
    
    public Student() {
    }

    public Student(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjects() {
        return this.subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

}
