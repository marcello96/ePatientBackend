package com.epatient.backend.converter;

import com.epatient.backend.model.dao.Doctor;
import com.epatient.backend.model.dto.DoctorCreationDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DoctorCreationDtoToDoctorConverter implements Converter<DoctorCreationDTO, Doctor> {

    @Override
    public Doctor convert(DoctorCreationDTO doctorCreationDTO) {
        Doctor doctor = new Doctor();
        doctor.setFirstname(doctorCreationDTO.getFirstname());
        doctor.setLastname(doctorCreationDTO.getLastname());
        doctor.setUsername(doctorCreationDTO.getUsername());
        doctor.setPassword(doctorCreationDTO.getPassword());
        return doctor;
    }
}
