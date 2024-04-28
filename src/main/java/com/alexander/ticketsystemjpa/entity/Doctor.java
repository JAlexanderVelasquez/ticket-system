package com.alexander.ticketsystemjpa.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
@Entity
@Table(name = "DOCTOR")
public class Doctor {
    @Id
    private Integer dni;
    private String name;
    private String surname;
    private String license;

    public int getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Doctor() {
    }
    public Doctor(int dni, String name, String surname, String license) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.license = license;
    }

    @JsonCreator
    public Doctor(@JsonProperty("dni") int dni){
        this.dni = dni;
    }
    @Override
    public String toString() {
        return "Doctor { dni=" + this.dni + ", name=" + this.name + ", surname=" + this.surname + ", license=" + this.license + "}" ;
//        return """
//                Doctor { dni=%s, name=%s, surname=%s, license=%s }
//                """.formatted(this.dni,this.name,this.surname,this.license);
    }
}
