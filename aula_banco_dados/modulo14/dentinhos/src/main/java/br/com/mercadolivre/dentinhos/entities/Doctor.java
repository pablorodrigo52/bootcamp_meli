package br.com.mercadolivre.dentinhos.entities;

public class Doctor extends User{
    
    private String specialty;

    public Doctor(String firstName, String lastName, String specialty){
        super(firstName, lastName);
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return this.specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

}
