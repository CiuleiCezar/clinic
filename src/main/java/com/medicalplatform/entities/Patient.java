package com.medicalplatform.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "patient")
public class Patient implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "dateofbirth", nullable = false)
    private String dateofbirth;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "medicalrecord", nullable = false)
    private String medicalRecord;

    @ManyToOne(fetch = FetchType.EAGER)
    private Caregiver caregiver;

    @OneToMany(mappedBy="patient",  cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<MedicationPlan> listOfMedicationPlan = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "user_id")
    private ClinicUser clinicUser;

    public Patient(UUID id, String name, String dateOfBirth,
                   String gender, String address, String medicalRecord,
                   Set<MedicationPlan> listOfMedicationPlan) {
        this.id = id;
        this.name = name;
        this.dateofbirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.medicalRecord = medicalRecord;
        this.listOfMedicationPlan = listOfMedicationPlan;
    }

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

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String birthDate) {
        this.dateofbirth = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(String medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public Patient() {
    }

    public Caregiver getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(Caregiver caregiver) {
        this.caregiver = caregiver;
    }

    public Set<MedicationPlan> getListOfMedicationPlan() {
        return listOfMedicationPlan;
    }

    public void setListOfMedicationPlan(Set<MedicationPlan> listOfMedicationPlan) {
        this.listOfMedicationPlan = listOfMedicationPlan;
    }

    public ClinicUser getClinicUser() {
        return clinicUser;
    }

    public void setClinicUser(ClinicUser clinicUser) {
        this.clinicUser = clinicUser;
    }

    public void addMedicationPlan(MedicationPlan medicationPlan){
        listOfMedicationPlan.add(medicationPlan);
        medicationPlan.setPatient(this);
    }
}