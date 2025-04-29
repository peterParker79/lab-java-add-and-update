package com.ironhack.addupdate.repositories;

import com.ironhack.addupdate.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
