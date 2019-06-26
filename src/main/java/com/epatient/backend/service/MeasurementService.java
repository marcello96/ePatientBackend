package com.epatient.backend.service;

import com.epatient.backend.converter.HeartRateHistoryToMeasurementDtoConverter;
import com.epatient.backend.converter.MeasurementDtoToHeartRateHistoryConverter;
import com.epatient.backend.exception.NoSuchPatientException;
import com.epatient.backend.model.dao.Patient;
import com.epatient.backend.model.dto.MeasurementDTO;
import com.epatient.backend.model.dto.MeasurementsDTO;
import com.epatient.backend.repository.HeartRateHistoryRepository;
import com.epatient.backend.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
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

    public void addMeasurement(long patientId, MeasurementDTO measurementDTO) throws NoSuchPatientException {
        Optional<Patient> patient = patientRepository.findById(patientId);

        if (patient.isPresent()) {
            heartRateHistoryRepository.save(measurementDtoToHeartRateHistoryConverter.convert(measurementDTO, patient.get()));
            return;
        }
        throw new NoSuchPatientException(patientId);
    }

    public MeasurementsDTO getMeasurements(long patientId) throws NoSuchPatientException {
        Optional<Patient> patient = patientRepository.findById(patientId);

        if (patient.isPresent()) {
            return new MeasurementsDTO(
                    patient.get()
                            .getHeartRates()
                            .stream()
                            .map(heartRateHistoryToMeasurementDtoConverter::convert)
                            .collect(Collectors.toList())
            );
        }
        throw new NoSuchPatientException(patientId);
    }
}
