package com.medicalplatform.services;

import com.medicalplatform.dtos.MedicationDTO;
import com.medicalplatform.dtos.builders.MedicationBuilder;
import com.medicalplatform.entities.Caregiver;
import com.medicalplatform.repositories.MedicationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.medicalplatform.controllers.handlers.exceptions.model.ResourceNotFoundException;
import com.medicalplatform.entities.Medication;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MedicationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MedicationService.class);
    private final MedicationRepository medicatonRepository;


    @Autowired
    public MedicationService(MedicationRepository medicatonRepository) {
        this.medicatonRepository = medicatonRepository;
    }

    public List<MedicationDTO> findMedications() {
        List<Medication> medicatonList = medicatonRepository.findAll();
        return medicatonList.stream()
                .map(MedicationBuilder::toMedicationDTO)
                .collect(Collectors.toList());
    }

    public MedicationDTO findMedicationById(UUID id) {
        Optional<Medication> prosumerOptional = medicatonRepository.findById(id);
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("Medication with id {} was not found in db", id);
            throw new ResourceNotFoundException(Medication.class.getSimpleName() + " with id: " + id);
        }
        return MedicationBuilder.toMedicationDTO(prosumerOptional.get());
    }

    public MedicationDTO deleteMedicationById(UUID id) {
        Optional<Medication> prosumerOptional = medicatonRepository.findById(id);
        medicatonRepository.deleteById(id);

        if (!prosumerOptional.isPresent()) {
            LOGGER.error("Medication with id {} was not found in db", id);
            throw new ResourceNotFoundException(Medication.class.getSimpleName() + " with id: " + id);
        }
        return MedicationBuilder.toMedicationDTO(prosumerOptional.get());
    }

    public UUID insert(MedicationDTO medicatonDTO) {
        Medication medicaton = MedicationBuilder.toEntity(medicatonDTO);
        medicaton = medicatonRepository.save(medicaton);
        LOGGER.debug("Medication with id {} was inserted in db", medicaton.getId());
        return medicaton.getId();
    }
}