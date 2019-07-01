package com.epatient.backend.service;

import com.epatient.backend.converter.DoctorCreationDtoToDoctorConverter;
import com.epatient.backend.converter.PatientCreationDtoToPatientConverter;
import com.epatient.backend.exception.UserExistsException;
import com.epatient.backend.model.dao.ApplicationUser;
import com.epatient.backend.model.dao.Doctor;
import com.epatient.backend.model.dao.Patient;
import com.epatient.backend.model.dto.DoctorCreationDTO;
import com.epatient.backend.model.dto.PatientCreationDTO;
import com.epatient.backend.repository.ApplicationUserRepository;
import com.epatient.backend.repository.DoctorRepository;
import com.epatient.backend.repository.PatientRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserManagementService {

    private final ApplicationUserRepository applicationUserRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final PasswordEncoder passwordEncoder;
    private final PatientCreationDtoToPatientConverter patientCreationDtoToPatientConverter;
    private final DoctorCreationDtoToDoctorConverter doctorCreationDtoToDoctorConverter;

    public UserManagementService(ApplicationUserRepository applicationUserRepository,
                                 PatientRepository patientRepository,
                                 DoctorRepository doctorRepository,
                                 PasswordEncoder passwordEncoder,
                                 PatientCreationDtoToPatientConverter patientCreationDtoToPatientConverter,
                                 DoctorCreationDtoToDoctorConverter doctorCreationDtoToDoctorConverter) {
        this.applicationUserRepository = applicationUserRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.passwordEncoder = passwordEncoder;
        this.patientCreationDtoToPatientConverter = patientCreationDtoToPatientConverter;
        this.doctorCreationDtoToDoctorConverter = doctorCreationDtoToDoctorConverter;
    }

    public void createPatient(PatientCreationDTO patientCreationDTO) throws UserExistsException {
        Patient patient = patientCreationDtoToPatientConverter.convert(patientCreationDTO);
        checkIfUserExists(patient);
        patient.setPassword(passwordEncoder.encode(patient.getPassword()));
        patientRepository.save(patient);
    }

    public void createDoctor(DoctorCreationDTO doctorCreationDTO) throws UserExistsException {
        Doctor doctor = doctorCreationDtoToDoctorConverter.convert(doctorCreationDTO);
        checkIfUserExists(doctor);
        doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
        doctorRepository.save(doctor);
    }

    private void checkIfUserExists(ApplicationUser applicationUser) throws UserExistsException {
        if(applicationUserRepository.findByUsername(applicationUser.getUsername()) != null) {
            throw new UserExistsException();
        }
    }
}
