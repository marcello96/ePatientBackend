package com.epatient.backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MeasurementsDTO {
    private List<MeasurementDTO> measurements;
}
