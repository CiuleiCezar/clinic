package com.medicalplatform.dtos.builders;

import com.medicalplatform.dtos.*;
import com.medicalplatform.entities.ClinicUser;
import com.medicalplatform.entities.Doctor;
import com.medicalplatform.entities.MedicationPlan;
import com.medicalplatform.entities.Person;

import java.util.ArrayList;
import java.util.List;

public class DoctorBuilder {

    private DoctorBuilder() {
    }

    public static DoctorDTO toDoctorDTO(Doctor doctor) {

        ClinicUserDTO clinicUserDTO = ClinicUserBuilder.toClinicUserDTO(doctor.getClinicUser());
        return new DoctorDTO(doctor.getId(),doctor.getName(), doctor.getGender(), doctor.getEmail(), clinicUserDTO);
    }


    public static Doctor toEntity(DoctorDTO doctorDTO) {

        return new Doctor(doctorDTO.getId(), doctorDTO.getName(), doctorDTO.getGender(), doctorDTO.getEmail());
    }

}
