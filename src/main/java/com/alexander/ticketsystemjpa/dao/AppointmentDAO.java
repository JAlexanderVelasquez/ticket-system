package com.alexander.ticketsystemjpa.dao;

import com.alexander.ticketsystemjpa.entity.Appointment;
import com.alexander.ticketsystemjpa.entity.AppointmentPK;
import com.alexander.ticketsystemjpa.service.IDoctorService;
import com.alexander.ticketsystemjpa.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class AppointmentDAO implements IAppointmentDAO {

    @Autowired
    private IDoctorService doctorService;
    @Autowired
    private IPatientService patientService;
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void addAppointment(Appointment appointment){
        System.out.println("\n\n-----\n"+appointment+"\n\n\n");
        entityManager.persist(appointment);
    }
    @Override
    public boolean appointmentExistsByPatient(int dni){
        String jpql = "from APPOINTMENT as a WHERE a.dni_patient = ?";
        int count = entityManager.createQuery(jpql).setParameter(0, dni).getResultList().size();
        return count > 0;
    }
    @Override
    public boolean appointmentExistsByDoctor(int dni){
        String jpql = "from APPOINTMENT as a WHERE a.dni_appointment = ?";
        int count = entityManager.createQuery(jpql).setParameter(0, dni).getResultList().size();
        return count > 0;
    }
    @Override
    public List<Appointment> getAllAppointments(){
        String query = "select a from Appointment a";
        return (List<Appointment>) entityManager.createQuery(query).getResultList();
    }
    @Override
    public List<Appointment> getAllAppointmentsByPatient(int dni){
        String jpql = "from Appointment as a WHERE a.appointmentPK.patient.dni = ?1";
        return (List<Appointment>) entityManager.createQuery(jpql).setParameter(1, dni).getResultList();
    }
    @Override
    public List<Appointment> getAllAppointmentsByDoctor(int dni){
        String jpql = "from Appointment as a WHERE a.appointmentPK.doctor.dni = ?1";
        return (List<Appointment>) entityManager.createQuery(jpql).setParameter(1, dni).getResultList();
    }
    @Override
    public Appointment getAppointmentById(int dni_patient, int dni_doctor){
        AppointmentPK appointmentPK = new AppointmentPK(dni_patient,dni_doctor);
        return entityManager.find(Appointment.class, appointmentPK);
    }
    @Override
    public void updateAppointment(Appointment appointment){
        AppointmentPK appointmentPK = appointment.getAppointmentPK();
        Appointment appointmentFromDB = getAppointmentById(appointmentPK.getPatientDni(), appointmentPK.getDoctorDni());

        if (appointmentFromDB != null) {
            appointmentFromDB.setAppointmentDate(appointment.getAppointmentDate());
            entityManager.flush();
        }
    }
    @Override
    public void deleteAppointment(int dni_patient, int dni_doctor){
        Appointment appointmentFromDB = getAppointmentById(dni_patient, dni_doctor);
        if (appointmentFromDB != null) {
            entityManager.remove(appointmentFromDB);
        }}
}
