package com.alexander.ticketsystemjpa.service;

import com.alexander.ticketsystemjpa.dao.IAppointmentDAO;
import com.alexander.ticketsystemjpa.dao.IDoctorDAO;
import com.alexander.ticketsystemjpa.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppointmentService implements IAppointmentService{

    @Autowired
    private IAppointmentDAO appointmentDAO;
    @Override
    public List<Appointment> getAllAppointments(){
        return appointmentDAO.getAllAppointments();
    }
    @Override
    public List<Appointment> getAllAppointmentsByPatient(int dni){
        return appointmentDAO.getAllAppointmentsByPatient(dni);
    }
    @Override
    public List<Appointment> getAllAppointmentsByDoctor(int dni){
        return appointmentDAO.getAllAppointmentsByDoctor(dni);
    }
    @Override
    public Appointment getAppointmentById(int dni_patient, int dni_doctor){
        return appointmentDAO.getAppointmentById(dni_patient, dni_doctor);
    }
    @Override
    public void addAppointment(Appointment appointment){
        appointmentDAO.addAppointment(appointment);
    }
    @Override
    public void updateAppointment(Appointment appointment){
        appointmentDAO.updateAppointment(appointment);
    }
    @Override
    public void deleteAppointment(int dni_patient, int dni_doctor){
        appointmentDAO.deleteAppointment(dni_patient,dni_doctor);
    }

}
