package com.medicalplatform.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.medicalplatform.dtos.MedicationPlanDTO;
import com.medicalplatform.services.MedicationPlanService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping(value = "/medicationPlan")
public class MedicationPlanController {

    private final MedicationPlanService medicationPlanService;

    @Autowired
    public MedicationPlanController(MedicationPlanService medicationPlanService) {
        this.medicationPlanService = medicationPlanService;
    }

    @GetMapping()
    public ResponseEntity<List<MedicationPlanDTO>> getMedicationPlans() {
        List<MedicationPlanDTO> dtos = medicationPlanService.findMedicationPlans();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping(value = "/{idPatient}")
    public ResponseEntity<UUID> insertProsumer(@Valid @RequestBody MedicationPlanDTO medicationPlanDTO, @PathVariable("idPatient") UUID idPatient) {
        UUID medicationPlanID = medicationPlanService.insert(medicationPlanDTO, idPatient);
        return new ResponseEntity<>(medicationPlanID, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MedicationPlanDTO> getMedicationPlan(@PathVariable("id") UUID medicationPlanId) {
        MedicationPlanDTO dto = medicationPlanService.findMedicationPlanById(medicationPlanId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<MedicationPlanDTO> deleteMedicationPlan(@PathVariable("id") UUID medicationPlanId){
        MedicationPlanDTO dto = medicationPlanService.deleteMedicationPlanById(medicationPlanId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }


}
