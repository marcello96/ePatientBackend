package com.epatient.backend.converter;

import com.epatient.backend.model.dao.Patient;
import com.epatient.backend.model.dto.PatientDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PatientToPatientDtoConverter implements Converter<Patient, PatientDTO> {

    @Override
    public PatientDTO convert(Patient patient) {
        return PatientDTO.builder()
                .username(patient.getUsername())
                .id(patient.getId())
                .firstname(patient.getFirstname())
                .lastname(patient.getLastname())
                .build();
    }
}
