package com.medicalplatform.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
public class Prescription implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id;


    @Column(name = "startInterval", nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date startInterval;

    @Column(name = "endInterval", nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date endInterval;
    @Column(name = "interval", nullable = false)
    private Integer interval;

    @ManyToOne
    @JoinColumn(name="prescription_plan_id", nullable=false)
    private MedicationPlan medicationPlan;

    @ManyToOne
    @JoinColumn(name="medication_id", nullable=false)
    private Medication medication;

    public Prescription() {
    }
}
