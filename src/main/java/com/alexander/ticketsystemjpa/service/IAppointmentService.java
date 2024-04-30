package com.alexander.ticketsystemjpa.service;

import com.alexander.ticketsystemjpa.entity.Appointment;

import java.util.List;

public interface IAppointmentService {
    List<Appointment> getAllAppointments();
    List<Appointment> getAllAppointmentsByPatient(int dni);
    List<Appointment> getAllAppointmentsByDoctor(int dni);
    Appointment getAppointmentById(int dni_patient, int dni_doctor);
    void addAppointment(Appointment appointment);
    void updateAppointment(Appointment appointment);
    void deleteAppointment(int dni_patient, int dni_doctor);

}
