package com.epatient.backend.model.dao;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@ToString(exclude = "patient")
@NoArgsConstructor
public class HeartRateHistory {

    @Id
    @NotNull
    @SequenceGenerator(name="hr_seq", sequenceName="hr_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hr_seq")
    private long id;

    @NotNull
    @Column
    private int value;

    @NotNull
    @Column
    private LocalDateTime measurementTime;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}
