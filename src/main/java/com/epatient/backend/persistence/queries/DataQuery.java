package com.epatient.backend.persistence.queries;

import com.epatient.backend.persistence.model.HeartRateData;

public interface DataQuery {

    int getHeartRateByID(String mibandid);

}
