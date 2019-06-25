package com.epatient.backend.converter;

import com.epatient.backend.model.dao.HeartRateData;
import com.epatient.backend.model.dto.MeasurementDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HeartRateDataToMeasurementDtoConverter implements Converter<HeartRateData, MeasurementDTO> {

    @Override
    public MeasurementDTO convert(HeartRateData heartRateData) {
        return MeasurementDTO.builder()
                .heartRate(heartRateData.getValue())
                .timestamp(heartRateData.getTimestamp())
                .build();
    }
}
