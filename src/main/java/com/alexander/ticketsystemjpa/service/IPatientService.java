package com.alexander.ticketsystemjpa.service;

import com.alexander.ticketsystemjpa.entity.Patient;

import java.util.List;

public interface IPatientService {
    List<Patient> getAllPatients();
    Patient getPatientById(int dni);
    void addPatient(Patient doctor);
    void updatePatient(Patient doctor);
    void deletePatient(int dni);

}
