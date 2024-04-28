package com.alexander.ticketsystemjpa.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "PATIENT")
public class Patient {
    @Id
    private Integer dni;
    private String name;
    private String surname;
    private String address;
    @CreationTimestamp
    private Date entryDate;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Patient() {
    }
    public Patient(int dni, String name, String surname, String address) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    @JsonCreator
    public Patient(@JsonProperty("dni") int dni){
        this.dni = dni;
    }
    @Override
    public String toString() {
        return "Patient { dni=" + this.dni + ", name=" + this.name + ", surname=" + this.surname + ", address=" + this.address + ", entryDate=" + this.entryDate + "}" ;
    }
}
