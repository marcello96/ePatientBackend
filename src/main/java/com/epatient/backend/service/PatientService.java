package com.epatient.backend.service;

import com.epatient.backend.converter.PatientToPatientDtoConverter;
import com.epatient.backend.model.dto.PatientsDTO;
import com.epatient.backend.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    private final PatientToPatientDtoConverter patientToPatientDtoConverter;

    public PatientService(PatientRepository patientRepository,
                          PatientToPatientDtoConverter patientToPatientDtoConverter) {
        this.patientRepository = patientRepository;
        this.patientToPatientDtoConverter = patientToPatientDtoConverter;
    }

    public PatientsDTO getPatients() {
        return new PatientsDTO(patientRepository.findAll()
                                            .stream()
                                            .map(patientToPatientDtoConverter::convert)
                                            .collect(Collectors.toList()));
    }
}
