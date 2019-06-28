package com.epatient.backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorCreationDTO {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
}
