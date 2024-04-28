package com.alexander.ticketsystemjpa.service;

import com.alexander.ticketsystemjpa.dao.IDoctorDAO;
import com.alexander.ticketsystemjpa.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService implements IDoctorService {

    @Autowired
    private IDoctorDAO doctorDAO;

    @Override
    public List<Doctor> getAllDoctors() { return doctorDAO.getAllDoctors(); }

    @Override
    public Doctor getDoctorById(int dni) {
        return doctorDAO.getDoctorById(dni);
    }

    @Override
    public void addDoctor(Doctor doctor) {
        doctorDAO.addDoctor(doctor);
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        doctorDAO.updateDoctor(doctor);
    }

    @Override
    public void deleteDoctor(int dni) {
        doctorDAO.deleteDoctor(dni);
    }
}
