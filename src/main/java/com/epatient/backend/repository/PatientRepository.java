package com.epatient.backend.repository;

import com.epatient.backend.model.dao.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    Patient findPatientById(int patientId);
}
