package com.alexander.ticketsystemjpa.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "APPOINTMENT")
public class Appointment {
    @EmbeddedId
    private AppointmentPK appointmentPK;
    private Timestamp appointmentDate;

    public AppointmentPK getAppointmentPK() {
        return appointmentPK;
    }

    public void setAppointmentPK(AppointmentPK appointmentPK) {
        this.appointmentPK = appointmentPK;
    }

    public Timestamp getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Timestamp appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Appointment() {
    }

    public Appointment(AppointmentPK appointmentPK, Timestamp appointmentDate) {
        this.appointmentPK = appointmentPK;
        this.appointmentDate = appointmentDate;
    }

    @Override
    public String toString() {
        return "Appointment { dni_patient=" + this.appointmentPK.patientDni + ", dni_doctor=" + this.appointmentPK.doctorDni + ", date=" + this.appointmentDate + "}" ;
    }
}
