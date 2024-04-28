package com.alexander.ticketsystemjpa.dao;

import com.alexander.ticketsystemjpa.entity.Patient;

import java.util.List;

public interface IPatientDAO {
    void addPatient(Patient patient);
    boolean patientExists(int dni);
    List<Patient> getAllPatients();
    Patient getPatientById(int dni);
    void updatePatient(Patient patient);
    void deletePatient(int dni);
}
