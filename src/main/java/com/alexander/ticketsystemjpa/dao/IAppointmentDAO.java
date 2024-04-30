package com.alexander.ticketsystemjpa.dao;

import com.alexander.ticketsystemjpa.entity.Appointment;

import java.util.List;

public interface IAppointmentDAO {
    void addAppointment(Appointment appointment);
    boolean appointmentExistsByPatient(int dni);
    boolean appointmentExistsByDoctor(int dni);
    List<Appointment> getAllAppointments();
    List<Appointment> getAllAppointmentsByPatient(int dni);
    List<Appointment> getAllAppointmentsByDoctor(int dni);
    Appointment getAppointmentById(int dni_patient, int dni_doctor);
    void updateAppointment(Appointment appointment);
    void deleteAppointment(int dni_patient, int dni_doctor);
}
