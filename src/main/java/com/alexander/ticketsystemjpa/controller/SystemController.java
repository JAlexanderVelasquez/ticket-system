package com.alexander.ticketsystemjpa.controller;

import com.alexander.ticketsystemjpa.entity.Doctor;
import com.alexander.ticketsystemjpa.entity.Patient;
import com.alexander.ticketsystemjpa.service.IDoctorService;
import com.alexander.ticketsystemjpa.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SystemController {
    @Autowired
    private IDoctorService doctorService;
    @Autowired
    private IPatientService patientService;

    //DOCTOR
    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> list = doctorService.getAllDoctors();
        return new ResponseEntity<List<Doctor>>(list, HttpStatus.OK);
    }
    @GetMapping("/doctor/{dni}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable("dni") Integer dni) {
        Doctor rs = doctorService.getDoctorById(dni);
        return rs == null ? new ResponseEntity<Doctor>(rs, HttpStatus.NOT_FOUND) : new ResponseEntity<Doctor>(rs, HttpStatus.OK);
    }
    @PostMapping("/doctor")
    public ResponseEntity<Void> addDoctor(@RequestBody Doctor doctor, UriComponentsBuilder builder) {
        doctorService.addDoctor(doctor);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/doctor/{id}").buildAndExpand(doctor.getDni()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @DeleteMapping("/doctor/{dni}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable("dni") Integer dni) {
        doctorService.deleteDoctor(dni);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/doctor")
    public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor) {
        doctorService.updateDoctor(doctor);
        return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
    }

//PATIENT
    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> list = patientService.getAllPatients();
        return new ResponseEntity<List<Patient>>(list, HttpStatus.OK);
    }
    @GetMapping("/patient/{dni}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("dni") Integer dni) {
        Patient rs = patientService.getPatientById(dni);
        return rs == null ? new ResponseEntity<Patient>(rs, HttpStatus.NOT_FOUND) : new ResponseEntity<Patient>(rs, HttpStatus.OK);
    }
    @PostMapping("/patient")
    public ResponseEntity<Void> addPatient(@RequestBody Patient patient, UriComponentsBuilder builder) {
        System.out.println("\n\ncall controller with "+ patient + "\n\n");
        patientService.addPatient(patient);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/patient/{id}").buildAndExpand(patient.getDni()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @DeleteMapping("/patient/{dni}")
    public ResponseEntity<Void> deletePatient(@PathVariable("dni") Integer dni) {
        patientService.deletePatient(dni);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/patient")
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient) {
        patientService.updatePatient(patient);
        return new ResponseEntity<Patient>(patient, HttpStatus.OK);
    }
}
