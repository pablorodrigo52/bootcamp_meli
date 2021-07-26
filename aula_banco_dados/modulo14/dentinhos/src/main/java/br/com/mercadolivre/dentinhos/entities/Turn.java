package br.com.mercadolivre.dentinhos.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "turn")
public class Turn {
    
    @Id
    private String id;
    private String date;
    private String status;

    @Field
    private Patient patient;
    @Field
    private Doctor doctor;

    public Turn(String id, Patient patient, Doctor doctor, String date, String status) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.status = status;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return this.doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
