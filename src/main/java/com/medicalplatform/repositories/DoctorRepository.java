package com.medicalplatform.repositories;

import com.medicalplatform.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import com.medicalplatform.entities.ClinicUser;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctor, UUID>{

}
