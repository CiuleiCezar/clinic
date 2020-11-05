package com.medicalplatform.repositories;

import com.medicalplatform.entities.MedicationPlan;
import com.medicalplatform.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import com.medicalplatform.entities.ClinicUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MedicationPlanRepository extends JpaRepository<MedicationPlan, UUID>{

    @Query(value = "SELECT m " +
            "FROM MedicationPlan m ")
    List<MedicationPlan> findMedicationPlan();
}
