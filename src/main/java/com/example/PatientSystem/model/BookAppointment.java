package com.example.PatientSystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import java.util.Date;

@Entity
public class BookAppointment {

    @Id
    @GeneratedValue
    private int id;
    private String email;
    private Date date;
    private String doctorName;

    public BookAppointment() {
    }

    public BookAppointment(int id, @Email String email, Date date, String doctorName) {
        this.id = id;
        this.email = email;
        this.date = date;
        this.doctorName = doctorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    @Override
    public String toString() {
        return "BookAppointment{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", date=" + date +
                ", doctorName='" + doctorName + '\'' +
                '}';
    }
}
