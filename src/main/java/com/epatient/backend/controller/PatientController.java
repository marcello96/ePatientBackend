package com.epatient.backend.controller;

import com.epatient.backend.exception.NoSuchPatientException;
import com.epatient.backend.model.dto.MeasurementDTO;
import com.epatient.backend.model.dto.MeasurementsDTO;
import com.epatient.backend.model.dto.PatientsDTO;
import com.epatient.backend.service.AuthenticationService;
import com.epatient.backend.service.MeasurementEventBus;
import com.epatient.backend.service.MeasurementService;
import com.epatient.backend.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.time.LocalDateTime;

@Slf4j
@RestController
public class PatientController {

    private final MeasurementService measurementService;
    private final MeasurementEventBus measurementEventBus;
    private final PatientService patientService;
    private final AuthenticationService authenticationService;

    public PatientController(MeasurementService measurementService,
                             MeasurementEventBus measurementEventBus,
                             PatientService patientService,
                             AuthenticationService authenticationService) {
        this.measurementService = measurementService;
        this.measurementEventBus = measurementEventBus;
        this.patientService = patientService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/patient/measurement")
    public void addMeasurement(@RequestBody MeasurementDTO measurementDTO) throws NoSuchPatientException {
        long patientId = authenticationService.getAuthenticatedUser().getId();
        measurementService.addMeasurement(patientId, measurementDTO);
        measurementEventBus.sendMeasurementEvent(patientId, measurementDTO);
    }

    @GetMapping("/patient/{patientId}/measurements")
    public MeasurementsDTO getHeartRateByID(@PathVariable long patientId,
                                            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,
                                            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime to) throws NoSuchPatientException {
        return measurementService.getMeasurements(patientId, from, to);
    }

    @GetMapping("/patients")
    public PatientsDTO getPatients() {
        return patientService.getPatients();
    }

    @GetMapping("/patient/{patientId}/measurements/subscribe")
    public SseEmitter subscribeLiveMeasurements(@PathVariable long patientId) {
        return measurementEventBus.createSseEmitterForPatient(patientId);
    }
}