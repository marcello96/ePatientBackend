package com.epatient.backend.service;

import com.epatient.backend.converter.HeartRateDataToMeasurementDtoConverter;
import com.epatient.backend.model.dto.MeasurementDTO;
import com.epatient.backend.model.dto.MeasurementsDTO;
import com.epatient.backend.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class MeasurementService {
    private final PatientRepository patientRepository;
    private final HeartRateDataToMeasurementDtoConverter converter;

    public MeasurementService(PatientRepository patientRepository,
                              HeartRateDataToMeasurementDtoConverter converter) {
        this.patientRepository = patientRepository;
        this.converter = converter;
    }

    public void addMeasurement(int patientId, MeasurementDTO measurementDTO) {

    }

    public MeasurementsDTO getMeasurements(int patientId) {
        return new MeasurementsDTO(
                patientRepository.findPatientById(patientId)
                .getHeartRates()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList())
        );
    }
}
