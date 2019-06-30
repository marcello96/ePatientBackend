package com.epatient.backend.model.dao;

import com.epatient.backend.security.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "patients")
@Data
@ToString(exclude = "heartRates")
@EqualsAndHashCode(callSuper = true)
public class Patient extends ApplicationUser {

    @NotNull
    @Column
    private String firstname;

    @NotNull
    @Column
    private String lastname;

    @NotNull
    @Column
    private int age;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    private List<HeartRateHistory> heartRates;

    public Patient() {
        this.setRole(Role.PATIENT);
    }
}
