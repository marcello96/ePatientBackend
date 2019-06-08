package com.epatient.backend.persistence.service;

import com.epatient.backend.persistence.queries.DataQuery;
import com.epatient.backend.persistence.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import com.epatient.backend.persistence.model.HeartRateData;

@Service
public class DataService implements DataQuery {

    private DataRepository dataRepository;

   @Autowired
    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }


    @Override
    public int getHeartRateByID(String mibandid) {
        return dataRepository.getHeartRateByID(mibandid);
    }

}
