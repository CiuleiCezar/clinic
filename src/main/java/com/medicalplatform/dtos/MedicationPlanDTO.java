package com.medicalplatform.dtos;

import com.medicalplatform.entities.Patient;
import com.medicalplatform.entities.Prescription;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class MedicationPlanDTO {

    private UUID id;
    private String name;
    private String startInterval;
    private String endInterval;
    private List<MedicationDTO> listOfMedication;

    public MedicationPlanDTO(UUID id, String name, String startInterval, String endInterval, List<MedicationDTO> listOfMedication) {
        this.id = id;
        this.name = name;
        this.startInterval = startInterval;
        this.endInterval = endInterval;
        this.listOfMedication = listOfMedication;
    }

    public MedicationPlanDTO(){

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

    public String getStartInterval() {
        return startInterval;
    }

    public void setStartInterval(String startInterval) {
        this.startInterval = startInterval;
    }

    public String getEndInterval() {
        return endInterval;
    }

    public void setEndInterval(String endInterval) {
        this.endInterval = endInterval;
    }

    public List<MedicationDTO> getListOfMedication() {
        return listOfMedication;
    }

    public void setListOfMedication(List<MedicationDTO> listOfMedication) {
        this.listOfMedication = listOfMedication;
    }
}
