package com.epatient.backend.persistence.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.text.SimpleDateFormat;

@Entity
@Table( name = "HEART_RATE_HISTORY" )
public class HeartRateData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column( name="MiBand_ID")
    private String MiBand_ID;

    private int Heart_Rate_Value;
    private String Read_Time;
    private String Created_On;
    private String Created_By;
    boolean active;

    public Integer getHeatRateDataID(){
        return this.id;
    }



}
