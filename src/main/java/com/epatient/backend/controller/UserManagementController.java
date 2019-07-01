package com.epatient.backend.controller;

import com.epatient.backend.exception.UserExistsException;
import com.epatient.backend.model.dto.DoctorCreationDTO;
import com.epatient.backend.model.dto.PatientCreationDTO;
import com.epatient.backend.service.UserManagementService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-management")
public class UserManagementController {

    private final UserManagementService userManagementService;

    public UserManagementController(UserManagementService userManagementService) {
        this.userManagementService = userManagementService;
    }

    @PostMapping("/patient")
    public void add(@RequestBody PatientCreationDTO patient) throws UserExistsException {
        userManagementService.createPatient(patient);
    }

    @PostMapping("/doctor")
    public void add(@RequestBody DoctorCreationDTO doctor) throws UserExistsException {
        userManagementService.createDoctor(doctor);
    }
}
