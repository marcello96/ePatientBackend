package com.epatient.backend.converter;

import com.epatient.backend.model.dao.Patient;
import com.epatient.backend.model.dto.PatientCreationDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PatientCreationDtoToPatientConverter implements Converter<PatientCreationDTO, Patient> {

    @Override
    public Patient convert(PatientCreationDTO patientCreationDTO) {
        Patient patient = new Patient();
        patient.setUsername(patientCreationDTO.getUsername());
        patient.setPassword(patientCreationDTO.getPassword());
        patient.setFirstname(patientCreationDTO.getFirstname());
        patient.setLastname(patientCreationDTO.getLastname());
        patient.setAge(patientCreationDTO.getAge());
        return patient;
    }
}
