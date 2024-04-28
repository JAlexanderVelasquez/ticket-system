package com.alexander.ticketsystemjpa.service;

import com.alexander.ticketsystemjpa.entity.Doctor;

import java.util.List;

public interface IDoctorService {
    List<Doctor> getAllDoctors();
    Doctor getDoctorById(int dni);
    void addDoctor(Doctor doctor);
    void updateDoctor(Doctor doctor);
    void deleteDoctor(int dni);

}
