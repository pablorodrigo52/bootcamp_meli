package br.com.mercadolivre.diploma.entities;

import java.util.List;

/**
 * Aluno
 */
public class Student {

    private String name;
    private List<Subject> course;
    
    public Student() {
    }

    public Student(String name, List<Subject> course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getCourse() {
        return this.course;
    }

    public void setCourse(List<Subject> course) {
        this.course = course;
    }

}
