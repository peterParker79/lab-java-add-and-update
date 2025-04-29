package com.ironhack.addupdate.controllers;


import com.ironhack.addupdate.dtos.PatientPatchDTO;
import com.ironhack.addupdate.models.Employee;
import com.ironhack.addupdate.models.Patient;
import com.ironhack.addupdate.repositories.PatientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @PatchMapping("/patient/update/{id}")
    @ResponseStatus(HttpStatus.CREATED) //201 Creado
    public Patient updatePatient(@PathVariable int id, @RequestBody PatientPatchDTO patientPatchDTO) {

        Patient exisitingPatient = patientRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (patientPatchDTO.getName() != null) {
            exisitingPatient.setName(patientPatchDTO.getName());
        }

        if (patientPatchDTO.getDateOfBirth() != null) {
            exisitingPatient.setDateOfBirth(patientPatchDTO.getDateOfBirth());
        }

        if (patientPatchDTO.getAdmittedBy() != null) {
            exisitingPatient.setAdmittedBy(patientPatchDTO.getAdmittedBy());
        }
    return patientRepository.save(exisitingPatient);
    }
}
