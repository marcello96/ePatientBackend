package com.epatient.backend.repository;

import com.epatient.backend.model.dao.HeartRateHistory;
import com.epatient.backend.model.dao.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface HeartRateHistoryRepository extends JpaRepository<HeartRateHistory, Integer> {

    List<HeartRateHistory> findAllByPatientEquals(Patient patient);
    List<HeartRateHistory> findAllByPatientEqualsAndMeasurementTimeBetween(Patient patient, LocalDateTime from, LocalDateTime to);
}
