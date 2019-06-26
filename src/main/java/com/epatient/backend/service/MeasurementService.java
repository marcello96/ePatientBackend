package com.epatient.backend.service;

import com.epatient.backend.converter.HeartRateHistoryToMeasurementDtoConverter;
import com.epatient.backend.converter.MeasurementDtoToHeartRateHistoryConverter;
import com.epatient.backend.model.dao.Patient;
import com.epatient.backend.model.dto.MeasurementDTO;
import com.epatient.backend.model.dto.MeasurementsDTO;
import com.epatient.backend.repository.HeartRateHistoryRepository;
import com.epatient.backend.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class MeasurementService {
    private final PatientRepository patientRepository;
    private final HeartRateHistoryRepository heartRateHistoryRepository;
    private final HeartRateHistoryToMeasurementDtoConverter heartRateHistoryToMeasurementDtoConverter;
    private final MeasurementDtoToHeartRateHistoryConverter measurementDtoToHeartRateHistoryConverter;

    public MeasurementService(PatientRepository patientRepository,
                              HeartRateHistoryRepository heartRateHistoryRepository, HeartRateHistoryToMeasurementDtoConverter heartRateHistoryToMeasurementDtoConverter,
                              MeasurementDtoToHeartRateHistoryConverter measurementDtoToHeartRateHistoryConverter) {
        this.patientRepository = patientRepository;
        this.heartRateHistoryRepository = heartRateHistoryRepository;
        this.heartRateHistoryToMeasurementDtoConverter = heartRateHistoryToMeasurementDtoConverter;
        this.measurementDtoToHeartRateHistoryConverter = measurementDtoToHeartRateHistoryConverter;
    }

    public void addMeasurement(long patientId, MeasurementDTO measurementDTO) {
        Patient patient = patientRepository.findPatientById(patientId);
        heartRateHistoryRepository.save(measurementDtoToHeartRateHistoryConverter.convert(measurementDTO, patient));
    }

    public MeasurementsDTO getMeasurements(long patientId) {
        return new MeasurementsDTO(
                patientRepository.findPatientById(patientId)
                .getHeartRates()
                .stream()
                .map(heartRateHistoryToMeasurementDtoConverter::convert)
                .collect(Collectors.toList())
        );
    }
}
