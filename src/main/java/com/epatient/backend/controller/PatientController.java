package com.epatient.backend.controller;

import com.epatient.backend.model.dto.MeasurementDTO;
import com.epatient.backend.model.dto.MeasurementsDTO;
import com.epatient.backend.service.MeasurementService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    private final MeasurementService measurementService;

    public PatientController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @PostMapping(value = "/patient/{patientId}/measurement")
    public void addMeasurement(@PathVariable long patientId, @RequestBody MeasurementDTO measurementDTO) {
        measurementService.addMeasurement(patientId, measurementDTO);
    }

    @GetMapping("/patient/{patientId}/measurements")
    public MeasurementsDTO getHeartRateByID(@PathVariable long patientId) {
        return measurementService.getMeasurements(patientId);
    }
}