package com.medicalplatform.dtos.builders;

import com.medicalplatform.dtos.ClinicUserDTO;
import com.medicalplatform.dtos.MedicationPlanDTO;
import com.medicalplatform.dtos.PatientDTO;
import com.medicalplatform.dtos.PatientDetailsDTO;
import com.medicalplatform.entities.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PatientBuilder {

    private PatientBuilder() {
    }

    public static PatientDTO toPatientDTO(Patient patient) {

        Set<MedicationPlanDTO> medicationPlans = new HashSet<MedicationPlanDTO>();

        if(patient.getListOfMedicationPlan().size() == 0){

        }
        else{
            for(MedicationPlan medicationPlan: patient.getListOfMedicationPlan()){
                MedicationPlanDTO medicationPlanDTO = MedicationPlanBuilder.toMedicationPlanDTO(medicationPlan);
                medicationPlans.add(medicationPlanDTO);
            }
        }

        ClinicUserDTO clinicUserDTO = new ClinicUserDTO(patient.getClinicUser().getId(),
                patient.getClinicUser().getUsername(), patient.getClinicUser().getPassword(), "PATIENT");

        return new PatientDTO(patient.getId(), patient.getName(), patient.getDateofbirth(),
                    patient.getGender(), patient.getAddress(), patient.getMedicalRecord(), clinicUserDTO, medicationPlans);
    }

    public static Patient toEntity(PatientDTO patientDTO) {

        ClinicUser clinicUser = ClinicUserBuilder.toEntity(patientDTO.getClinicUser());

        Patient patient = new Patient();
        patient.setId(patientDTO.getId());
        patient.setName(patientDTO.getName());
        patient.setDateofbirth(patientDTO.getDateofbirth());
        patient.setGender(patientDTO.getGender());
        patient.setAddress(patientDTO.getAddress());
        patient.setMedicalRecord(patientDTO.getMedicalRecord());
        patient.setClinicUser(clinicUser);

        Set<MedicationPlan> medicationPlans = new HashSet<>();
        if(medicationPlans.size() > 0){
            for(MedicationPlanDTO medicationPlanDTO: patientDTO.getListOfMedicalPlan()){
                MedicationPlan medicationPlan = MedicationPlanBuilder.toEntity(medicationPlanDTO);
                medicationPlans.add(medicationPlan);
            }
        }


        patient.setListOfMedicationPlan(medicationPlans);
        return patient;
    }


    public static Patient toEntity1(PatientDetailsDTO patientDTO) {

        Patient patient = new Patient();
        patient.setId(patientDTO.getId());
        patient.setName(patientDTO.getName());
        patient.setAddress(patientDTO.getAddress());

        return patient;
    }
}

