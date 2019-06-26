package com.epatient.backend.repository;

import com.epatient.backend.model.dao.HeartRateHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeartRateHistoryRepository extends JpaRepository<HeartRateHistory, Integer> {
}
