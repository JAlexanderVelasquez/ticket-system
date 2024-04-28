package com.alexander.ticketsystemjpa.dao;

import com.alexander.ticketsystemjpa.entity.Patient;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class PatientDAO implements IPatientDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addPatient(Patient patient) {
        System.out.println("\n\ncall add with "+ patient + "\n\n");
        entityManager.persist(patient);
    }
    @Override
    public boolean patientExists(int dni){
        String jpql = "from PATIENT as p WHERE p.dni = ?";
        int count = entityManager.createQuery(jpql).setParameter(0, dni).getResultList().size();
        return count > 0;
    }
    @Override
    public List<Patient> getAllPatients(){
        String query = "select p from Patient p order by p.dni";
        return (List<Patient>) entityManager.createQuery(query).getResultList();
    }
    @Override
    public Patient getPatientById(int dni) {
        return entityManager.find(Patient.class, dni);
    }
    @Override
    public void updatePatient(Patient patient) {
        Patient patientFromDB = getPatientById(patient.getDni());
        if (patientFromDB != null) {
            patientFromDB.setName(patient.getName());
            patientFromDB.setSurname(patient.getSurname());
            patientFromDB.setAddress(patient.getAddress());

            entityManager.flush();
        }
    }
    @Override
    public void deletePatient(int dni) {
        Patient pat = getPatientById(dni);
        if (pat != null) {
            entityManager.remove(getPatientById(dni));
        }
    }
}
