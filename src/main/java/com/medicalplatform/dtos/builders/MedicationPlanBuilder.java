package com.medicalplatform.dtos.builders;

import com.medicalplatform.dtos.*;
import com.medicalplatform.entities.Doctor;
import com.medicalplatform.entities.Medication;
import com.medicalplatform.entities.MedicationPlan;
import com.medicalplatform.entities.Patient;

import java.util.ArrayList;
import java.util.List;

public class MedicationPlanBuilder {

    private MedicationPlanBuilder() {
    }

    public static MedicationPlanDTO toMedicationPlanDTO(MedicationPlan medicationPlan){

        List<MedicationDTO> medications = new ArrayList<>();

        if(medicationPlan.getListOfMedication().size() == 0){

        }
        else{
            for(Medication medication: medicationPlan.getListOfMedication()){
                MedicationDTO medicationDTO = MedicationBuilder.toMedicationDTO(medication);
                medications.add(medicationDTO);
            }

        }


        return new MedicationPlanDTO(medicationPlan.getId(), medicationPlan.getName(),
                medicationPlan.getStartInterval(),medicationPlan.getEndInterval(),medications);
    }

    public static MedicationPlan toEntity(MedicationPlanDTO medicationPlanDTO) {


       MedicationPlan medicationPlan = new MedicationPlan();
       medicationPlan.setId(medicationPlanDTO.getId());
       medicationPlan.setName(medicationPlanDTO.getName());
       medicationPlan.setStartInterval(medicationPlanDTO.getStartInterval());
       medicationPlan.setEndInterval(medicationPlanDTO.getEndInterval());


       if(medicationPlanDTO.getListOfMedication() == null){

       }
       else {
           List<Medication> medications = new ArrayList<Medication>();


           for (MedicationDTO medicationDTO : medicationPlanDTO.getListOfMedication()) {
               Medication medication = MedicationBuilder.toEntity(medicationDTO);
               medications.add(medication);
           }
           medicationPlan.setListOfMedication(medications);
       }

        return medicationPlan;
    }

    public static MedicationPlan toEntity1(MedicationPlanDTO medicationPlanDTO) {

        MedicationPlan medicationPlan = new MedicationPlan();
        medicationPlan.setId(medicationPlanDTO.getId());
        medicationPlan.setName(medicationPlanDTO.getName());
        medicationPlan.setStartInterval(medicationPlanDTO.getStartInterval());
        medicationPlan.setEndInterval(medicationPlanDTO.getEndInterval());
        return medicationPlan;
    }
}
