package com.alexander.ticketsystemjpa.dao;

import com.alexander.ticketsystemjpa.entity.Doctor;

import java.util.List;

public interface IDoctorDAO {
    void addDoctor(Doctor doctor);
    boolean doctorExists(int dni);
    List<Doctor> getAllDoctors();
    Doctor getDoctorById(int dni);
    void updateDoctor(Doctor doctor);
    void deleteDoctor(int dni);
}
