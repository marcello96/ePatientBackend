package com.epatient.backend.persistence.queries;

import com.epatient.backend.persistence.model.HeartRateData;

import java.util.List;

public interface DataQuery {

    int getHeartRateByID(String mibandid);

    List<Integer> getHeartRateValuesFromRecentPeriod(String miband_id, String start_date);
}
