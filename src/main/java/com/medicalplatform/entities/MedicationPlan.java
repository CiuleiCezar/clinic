package com.medicalplatform.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class MedicationPlan implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "startInterval", nullable = false)
    private String startInterval;

    @Column(name = "endInterval", nullable = false)
    private String endInterval;

    @ManyToOne(fetch = FetchType.EAGER)
    private Patient patient;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(cascade = {
            CascadeType.MERGE})
    @JoinTable(
            name="medication_of_plan",
            joinColumns = @JoinColumn(name = "medication_id"),
            inverseJoinColumns = @JoinColumn(name = "medicationplan_id")
    )
    private List<Medication> listOfMedication = new ArrayList<>();

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartInterval() {
        return startInterval;
    }

    public void setStartInterval(String startInterval) {
        this.startInterval = startInterval;
    }

    public String getEndInterval() {
        return endInterval;
    }

    public void setEndInterval(String endInterval) {
        this.endInterval = endInterval;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Medication> getListOfMedication() {
        return listOfMedication;
    }

    public void setListOfMedication(List<Medication> listOfMedication) {
        this.listOfMedication = listOfMedication;
    }

    public MedicationPlan() {
    }

    public MedicationPlan(UUID id, String name, String startInterval, String endInterval,
                      Patient patient, List<Medication> listOfMedication){
        this.id = id;
        this.name = name;
        this.startInterval = startInterval;
        this.endInterval = endInterval;
        this.patient = patient;
        this.listOfMedication = listOfMedication;
    }

    public void addMedication(Medication medication){
        listOfMedication.add(medication);
    }

}
