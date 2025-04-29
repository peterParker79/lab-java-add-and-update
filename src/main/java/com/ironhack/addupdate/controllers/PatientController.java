package com.ironhack.addupdate.controllers;


import com.ironhack.addupdate.models.Patient;
import com.ironhack.addupdate.repositories.PatientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private EmployeeController employeeController;

    @PostMapping("/patient/add-new-patient")
    @ResponseStatus(HttpStatus.CREATED) //201 Creado
    public Patient addPatient(@RequestBody @Valid Patient patient) {

        return patientRepository.save(patient);
    }
}
