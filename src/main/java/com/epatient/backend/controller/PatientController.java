package com.epatient.backend.controller;

import com.epatient.backend.model.dto.MeasurementDTO;
import com.epatient.backend.model.dto.MeasurementsDTO;
import com.epatient.backend.service.MeasurementEventBus;
import com.epatient.backend.service.MeasurementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Slf4j
@RestController
public class PatientController {

    private final MeasurementService measurementService;
    private final MeasurementEventBus measurementEventBus;

    public PatientController(MeasurementService measurementService, MeasurementEventBus measurementEventBus) {
        this.measurementService = measurementService;
        this.measurementEventBus = measurementEventBus;
    }

    @PostMapping("/patient/{patientId}/measurement")
    public void addMeasurement(@PathVariable long patientId, @RequestBody MeasurementDTO measurementDTO) {
        measurementService.addMeasurement(patientId, measurementDTO);
        measurementEventBus.sendMeasurementEvent(patientId, measurementDTO);
    }

    @GetMapping("/patient/{patientId}/measurements")
    public MeasurementsDTO getHeartRateByID(@PathVariable long patientId) {
        return measurementService.getMeasurements(patientId);
    }

    @GetMapping("/patient/{patientId}/measurements/subscribe")
    public SseEmitter subscribeLiveMeasurements(@PathVariable long patientId) {
        return measurementEventBus.createSseEmitterForPatient(patientId);
    }
}