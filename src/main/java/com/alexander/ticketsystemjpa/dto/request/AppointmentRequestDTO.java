package com.alexander.ticketsystemjpa.dto.request;

import com.alexander.ticketsystemjpa.entity.Appointment;
import com.alexander.ticketsystemjpa.entity.AppointmentPK;
import com.alexander.ticketsystemjpa.entity.Doctor;
import com.alexander.ticketsystemjpa.entity.Patient;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

public class AppointmentRequestDTO {
    private int patientDni;
    private int doctorDni;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Europe/Berlin")
    private Timestamp date;


    public int getPatientDni() {
        return patientDni;
    }

    public void setPatientDni(int patientDni) {
        this.patientDni = patientDni;
    }

    public int getDoctorDni() {
        return doctorDni;
    }

    public void setDoctorDni(int doctorDni) {
        this.doctorDni = doctorDni;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public AppointmentRequestDTO() {
    }

    public AppointmentRequestDTO(int patientDni, int doctorDni, Timestamp date) {
        this.patientDni = patientDni;
        this.doctorDni = doctorDni;
        this.date = date;
    }

    @JsonCreator
    public AppointmentRequestDTO(@JsonProperty("patient") int patientDni,@JsonProperty("doctor") int doctorDni){
        this.patientDni = patientDni;
        this.doctorDni = doctorDni;
    }
    @Override
    public String toString() {
        return "AppointmentRequestDTO { dni_patient=" + this.patientDni + ", dni_doctor=" + this.doctorDni + ", date=" + this.date + "}" ;
    }
}
