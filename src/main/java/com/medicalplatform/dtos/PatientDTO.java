package com.medicalplatform.dtos;

import java.util.*;

public class PatientDTO {

    private UUID id;
    private String name;
    private String dateofbirth;
    private String gender;
    private String address;
    private String medicalRecord;
    private ClinicUserDTO clinicUser;
    private Set<MedicationPlanDTO> listOfMedicalPlan = new HashSet<>();

    public Set<MedicationPlanDTO> getListOfMedicalPlan() {
        return listOfMedicalPlan;
    }

    public void setListOfMedicalPlan(Set<MedicationPlanDTO> listOfMedicalPlan) {
        this.listOfMedicalPlan = listOfMedicalPlan;
    }

    public ClinicUserDTO getClinicUser() {
        return clinicUser;
    }

    public void setClinicUser(ClinicUserDTO clinicUser) {
        this.clinicUser = clinicUser;
    }

    public PatientDTO(UUID id, String name, String dateofbirth,
                      String gender, String address, String medicalRecord,
                      ClinicUserDTO clinicUser, Set<MedicationPlanDTO> listOfMedicalPlan) {
        this.id = id;
        this.name = name;
        this.dateofbirth = dateofbirth;
        this.gender = gender;
        this.address = address;
        this.medicalRecord = medicalRecord;
        this.clinicUser = clinicUser;
        this.listOfMedicalPlan = listOfMedicalPlan;
    }

    public PatientDTO() {
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

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientDTO that = (PatientDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(dateofbirth, that.dateofbirth) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(address, that.address) &&
                Objects.equals(medicalRecord, that.medicalRecord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateofbirth, gender, address, medicalRecord);
    }
}
