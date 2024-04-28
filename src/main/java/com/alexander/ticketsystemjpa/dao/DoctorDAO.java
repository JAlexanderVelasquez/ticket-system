package com.alexander.ticketsystemjpa.dao;

import com.alexander.ticketsystemjpa.entity.Doctor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class DoctorDAO implements IDoctorDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addDoctor(Doctor doctor) {
        entityManager.persist(doctor);
    }
    @Override
    public boolean doctorExists(int dni){
        String jpql = "from DOCTOR as d WHERE d.dni = ?";
        int count = entityManager.createQuery(jpql).setParameter(0, dni).getResultList().size();
        return count > 0;
    }
    @Override
    public List<Doctor> getAllDoctors(){
        String query = "select d from Doctor d order by d.dni";
        return (List<Doctor>) entityManager.createQuery(query).getResultList();
    }
    @Override
    public Doctor getDoctorById(int dni) {
        return entityManager.find(Doctor.class, dni);
    }
    @Override
    public void updateDoctor(Doctor doctor) {
        Doctor doctorFromDB = getDoctorById(doctor.getDni());

        if (doctorFromDB != null) {
            doctorFromDB.setName(doctor.getName());
            doctorFromDB.setSurname(doctor.getSurname());
            doctorFromDB.setLicense(doctor.getLicense());

            entityManager.flush();
        }
    }
    @Override
    public void deleteDoctor(int dni) {
        Doctor doc = getDoctorById(dni);
        if (doc != null) {
            entityManager.remove(getDoctorById(dni));
        }
    }
}
