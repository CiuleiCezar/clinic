package com.medicalplatform.services;

import com.medicalplatform.dtos.MedicationPlanDTO;
import com.medicalplatform.dtos.builders.MedicationPlanBuilder;
import com.medicalplatform.entities.*;
import com.medicalplatform.repositories.DoctorRepository;
import com.medicalplatform.repositories.MedicationPlanRepository;
import com.medicalplatform.repositories.MedicationRepository;
import com.medicalplatform.repositories.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.medicalplatform.controllers.handlers.exceptions.model.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MedicationPlanService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MedicationPlanService.class);
    private final MedicationPlanRepository medicationPlanRepository;
    private final MedicationRepository medicationRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Autowired
    public MedicationPlanService(MedicationPlanRepository medicationPlanRepository,
                                 MedicationRepository medicationRepository,
                                 PatientRepository patientRepository,
                                 DoctorRepository doctorRepository) {
        this.medicationPlanRepository = medicationPlanRepository;
        this.medicationRepository = medicationRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    public List<MedicationPlanDTO> findMedicationPlans() {
        List<MedicationPlan> medicationPlanList = medicationPlanRepository.findAll();
        List<MedicationPlanDTO> medicationPlanDTOList =  medicationPlanList.stream()
                .map(MedicationPlanBuilder::toMedicationPlanDTO)
                .collect(Collectors.toList());
        return medicationPlanDTOList;
    }

    public MedicationPlanDTO findMedicationPlanById(UUID id) {
        Optional<MedicationPlan> prosumerOptional = medicationPlanRepository.findById(id);
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("MedicationPlan with id {} was not found in db", id);
            throw new ResourceNotFoundException(MedicationPlan.class.getSimpleName() + " with id: " + id);
        }
        return MedicationPlanBuilder.toMedicationPlanDTO(prosumerOptional.get());
    }

    public MedicationPlanDTO deleteMedicationPlanById(UUID id){
        Optional<MedicationPlan> prosumerOptional = medicationPlanRepository.findById(id);
        medicationPlanRepository.deleteById(id);


        if (!prosumerOptional.isPresent()) {
            LOGGER.error("MedicationPlan with id {} was not found in db", id);
            throw new ResourceNotFoundException(MedicationPlan.class.getSimpleName() + " with id: " + id);
        }
        return MedicationPlanBuilder.toMedicationPlanDTO(prosumerOptional.get());
    }

    public UUID insert(MedicationPlanDTO medicationPlanDTO, UUID idPatient) {

        MedicationPlan medicationPlan = MedicationPlanBuilder.toEntity(medicationPlanDTO);
        Optional<Patient> prosumerOptional = patientRepository.findById(idPatient);
        medicationPlan.setPatient(prosumerOptional.get());
        medicationPlan = medicationPlanRepository.save(medicationPlan);
        LOGGER.debug("MedicationPlan with id {} was inserted in db", medicationPlan.getId());


        if (!prosumerOptional.isPresent()) {
            LOGGER.error("Patient with id {} was not found in db", idPatient);
            throw new ResourceNotFoundException(Caregiver.class.getSimpleName() + " with id: " + idPatient);
        }
        prosumerOptional.get().addMedicationPlan(medicationPlan);


        medicationPlan = medicationPlanRepository.save(medicationPlan);
        return medicationPlan.getId();
    }

    public UUID addMedication(UUID medicationId, UUID medicationPlanId){

        Optional<MedicationPlan> prosumerOptional = medicationPlanRepository.findById(medicationPlanId);
        Optional<Medication> prosumerOptional2 = medicationRepository.findById(medicationId);
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("Medication with id {} was not found in db", medicationId);
            throw new ResourceNotFoundException(Caregiver.class.getSimpleName() + " with id: " + medicationId);
        }
        prosumerOptional.get().addMedication(prosumerOptional2.get());
        MedicationPlan medicationPlan = medicationPlanRepository.save(prosumerOptional.get());

        return medicationPlan.getId();
    }
}

