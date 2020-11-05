package com.medicalplatform.dtos;

import com.medicalplatform.entities.ClinicUser;
import com.medicalplatform.entities.Doctor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class DoctorDTO {

    private UUID id;
    private String name;
    private String gender;
    private String email;
    private ClinicUserDTO clinicUser;

    public DoctorDTO(UUID id, String name, String gender, String email, ClinicUserDTO clinicUser) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.clinicUser = clinicUser;
    }

    public DoctorDTO() {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ClinicUserDTO getClinicUser() {
        return clinicUser;
    }

    public void setClinicUser(ClinicUserDTO clinicUser) {
        this.clinicUser = clinicUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorDTO doctorDTO = (DoctorDTO) o;
        return Objects.equals(id, doctorDTO.id) &&
                Objects.equals(name, doctorDTO.name) &&
                Objects.equals(gender, doctorDTO.gender) &&
                Objects.equals(email, doctorDTO.email) &&
                Objects.equals(clinicUser, doctorDTO.clinicUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, email, clinicUser);
    }


}
