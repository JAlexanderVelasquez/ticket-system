package com.alexander.ticketsystemjpa.service;

import com.alexander.ticketsystemjpa.dao.IDoctorDAO;
import com.alexander.ticketsystemjpa.dao.IPatientDAO;
import com.alexander.ticketsystemjpa.entity.Doctor;
import com.alexander.ticketsystemjpa.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements IPatientService {

    @Autowired
    private IPatientDAO patientDAO;

    @Override
    public List<Patient> getAllPatients() {
        return patientDAO.getAllPatients();
    }

    @Override
    public Patient getPatientById(int dni) {
        return patientDAO.getPatientById(dni);
    }

    @Override
    public void addPatient(Patient patient) {
        patientDAO.addPatient(patient);
    }

    @Override
    public void updatePatient(Patient patient) {
        patientDAO.updatePatient(patient);
    }

    @Override
    public void deletePatient(int dni) {
        patientDAO.deletePatient(dni);
    }
}
