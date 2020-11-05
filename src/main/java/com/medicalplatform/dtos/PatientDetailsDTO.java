package com.medicalplatform.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class PatientDetailsDTO {

    private UUID id;
    private String name;
    private String dateofbirth;
    private String gender;
    private String address;
    private String medicalRecord;

    public PatientDetailsDTO(UUID id, String name, String dateofbirth,
                      String gender, String address, String medicalRecord) {
        this.id = id;
        this.name = name;
        this.dateofbirth = dateofbirth;
        this.gender = gender;
        this.address = address;
        this.medicalRecord = medicalRecord;
    }

    public PatientDetailsDTO() {
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
        PatientDetailsDTO that = (PatientDetailsDTO) o;
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
