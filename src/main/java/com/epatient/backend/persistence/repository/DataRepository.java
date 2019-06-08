package com.epatient.backend.persistence.repository;

import com.epatient.backend.persistence.model.HeartRateData;
import com.epatient.backend.persistence.queries.DataQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DataRepository extends JpaRepository<HeartRateData, Integer>, DataQuery {

    @Override
    @Query("select id from HeartRateData")
    int getHeartRateByID(@Param("mibandid") String mibandid);

}
