package com.epatient.backend.persistence.queries;

import com.epatient.backend.persistence.model.HeartRateData;

public interface DataQuery {

    HeartRateData getHeartRateByID(String mibandid);

}
