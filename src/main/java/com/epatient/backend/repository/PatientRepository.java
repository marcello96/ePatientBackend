package com.epatient.backend.repository;

import com.epatient.backend.model.dao.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findAll();
    Optional<Patient> findById(Long id);
}
