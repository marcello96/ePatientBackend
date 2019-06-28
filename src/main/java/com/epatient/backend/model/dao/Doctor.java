package com.epatient.backend.model.dao;

import com.epatient.backend.security.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "doctors")
@Data
@EqualsAndHashCode(callSuper = true)
public class Doctor extends ApplicationUser {

    @NotNull
    @Column
    private String firstname;

    @NotNull
    @Column
    private String lastname;

    public Doctor() {
        this.setRole(Role.DOCTOR);
    }
}
