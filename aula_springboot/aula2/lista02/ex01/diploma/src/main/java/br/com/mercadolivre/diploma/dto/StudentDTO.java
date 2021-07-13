package br.com.mercadolivre.diploma.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import br.com.mercadolivre.diploma.entities.Student;
import br.com.mercadolivre.diploma.entities.Subject;

/**
 * StudentDTO
 */
public class StudentDTO {

    @NotNull
    @Size(min = 8, max = 50)
    @Pattern(regexp = "^[A-Za-z_ ]*$")
    private String name;
    
    @Valid
    @NotNull
    @Size(max = 10)
    private List<Subject> subjects;
    
    public StudentDTO() {
    }

    public StudentDTO(String name, List<Subject> subjects) {
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

    public static Student convert (StudentDTO dto){
        return new Student(dto.getName(), dto.getSubjects());
    }
}
