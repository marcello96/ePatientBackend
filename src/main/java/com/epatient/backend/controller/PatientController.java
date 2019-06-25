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
//@CrossOrigin("http://localhost:3000")
public class PatientController {

    private final MeasurementService measurementService;

    public PatientController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @RequestMapping("/test")
    public String index2() {
        return "TEST!";
    }

    @PostMapping(value = "/patient/{patientId}/measurement")
    public void addMeasurement(@PathVariable int patientId, @RequestBody MeasurementDTO measurementDTO) {
        measurementService.addMeasurement(patientId, measurementDTO);
    }

    @GetMapping("/patient/{patientId}/measurement")
    public MeasurementsDTO getHeartRateByID(@PathVariable int patientId) {
        return measurementService.getMeasurements(patientId);
    }
}