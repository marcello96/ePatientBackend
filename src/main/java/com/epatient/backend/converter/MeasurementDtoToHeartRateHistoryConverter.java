package com.epatient.backend.converter;

import com.epatient.backend.model.dao.HeartRateHistory;
import com.epatient.backend.model.dao.Patient;
import com.epatient.backend.model.dto.MeasurementDTO;
import org.springframework.stereotype.Component;

@Component
public class MeasurementDtoToHeartRateHistoryConverter implements BiConverter<MeasurementDTO, Patient, HeartRateHistory> {

    @Override
    public HeartRateHistory convert(MeasurementDTO measurementDTO, Patient patient) {
        HeartRateHistory hr = new HeartRateHistory();
        hr.setPatient(patient);
        hr.setValue(measurementDTO.getHeartRate());
        hr.setMeasurementTime(measurementDTO.getTimestamp());
        return hr;
    }
}
