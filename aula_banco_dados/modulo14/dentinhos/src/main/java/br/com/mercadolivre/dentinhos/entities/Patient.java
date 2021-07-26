package br.com.mercadolivre.dentinhos.entities;

public class Patient extends User{
    
    private int age;
    private String gender;

    public Patient(String firstName, String lastName, int age, String gender){
        super(firstName, lastName);
        this.age = age;
        this.gender = gender;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
