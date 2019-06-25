package com.epatient.backend.model.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class MeasurementDTO {
    private LocalDateTime timestamp;
    private int heartRate;
}
