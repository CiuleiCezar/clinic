package com.medicalplatform.dtos.builders;

import com.medicalplatform.dtos.ClinicUserDTO;
import com.medicalplatform.dtos.PersonDTO;
import com.medicalplatform.dtos.PersonDetailsDTO;
import com.medicalplatform.entities.ClinicUser;
import com.medicalplatform.entities.Person;

public class ClinicUserBuilder {

    private ClinicUserBuilder() {
    }

    public static ClinicUserDTO toClinicUserDTO(ClinicUser clinicUser) {
        return new ClinicUserDTO(clinicUser.getId(),clinicUser.getUsername(), clinicUser.getPassword(), clinicUser.getType());
    }

    public static ClinicUser toEntity(ClinicUserDTO clinicUserDTO) {
        return new ClinicUser(clinicUserDTO.getId(),
                clinicUserDTO.getUsername(),
                clinicUserDTO.getPassword(),
                clinicUserDTO.getType());
    }

}
