package com.epatient.backend.converter;

import com.epatient.backend.model.dao.HeartRateHistory;
import com.epatient.backend.model.dto.MeasurementDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HeartRateHistoryToMeasurementDtoConverter implements Converter<HeartRateHistory, MeasurementDTO> {

    @Override
    public MeasurementDTO convert(HeartRateHistory heartRateHistory) {
        return MeasurementDTO.builder()
                .heartRate(heartRateHistory.getValue())
                .timestamp(heartRateHistory.getMeasurementTime())
                .build();
    }
}
