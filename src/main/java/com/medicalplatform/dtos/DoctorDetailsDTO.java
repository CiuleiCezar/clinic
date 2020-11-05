package com.medicalplatform.dtos;

import com.medicalplatform.entities.ClinicUser;
import com.medicalplatform.entities.Doctor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class DoctorDetailsDTO {

    private UUID id;
    private String name;
    private String email;

    public DoctorDetailsDTO(UUID id, String name,  String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public DoctorDetailsDTO() {
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



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorDetailsDTO doctorDTO = (DoctorDetailsDTO) o;
        return Objects.equals(id, doctorDTO.id) &&
                Objects.equals(name, doctorDTO.name) &&
                Objects.equals(email, doctorDTO.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email );
    }


}
