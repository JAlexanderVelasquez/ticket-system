package com.alexander.ticketsystemjpa.entity;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class AppointmentPK implements Serializable {

    protected int patientDni;

    protected int doctorDni;

    public int getPatientDni() {
        return patientDni;
    }

    public int getDoctorDni() {
        return doctorDni;
    }

    public AppointmentPK() {
    }

    public AppointmentPK(int patientDni, int doctorDni) {
        this.patientDni = patientDni;
        this.doctorDni = doctorDni;
    }

    @Override
    public String toString() {
        return "AppointmentPK { patient=" + this.patientDni + ", doctor=" + this.doctorDni + "}" ;
    }
}
