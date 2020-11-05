package com.medicalplatform.dtos;

import com.medicalplatform.entities.Medication;
import com.medicalplatform.entities.MedicationPlan;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class PrescriptionDTO {

    private UUID id;
    private Date startInterval;
    private Date endInterval;
    private Integer interval;
    private MedicationPlanDTO medicationPlan;
    private MedicationDTO medication;

    public PrescriptionDTO(UUID id, Date startInterval, Date endInterval, Integer interval, MedicationPlanDTO medicationPlan, MedicationDTO medication) {
        this.id = id;
        this.startInterval = startInterval;
        this.endInterval = endInterval;
        this.interval = interval;
        this.medicationPlan = medicationPlan;
        this.medication = medication;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getStartInterval() {
        return startInterval;
    }

    public void setStartInterval(Date startInterval) {
        this.startInterval = startInterval;
    }

    public Date getEndInterval() {
        return endInterval;
    }

    public void setEndInterval(Date endInterval) {
        this.endInterval = endInterval;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public MedicationPlanDTO getMedicationPlan() {
        return medicationPlan;
    }

    public void setMedicationPlan(MedicationPlanDTO medicationPlan) {
        this.medicationPlan = medicationPlan;
    }

    public MedicationDTO getMedication() {
        return medication;
    }

    public void setMedication(MedicationDTO medication) {
        this.medication = medication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrescriptionDTO that = (PrescriptionDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(startInterval, that.startInterval) &&
                Objects.equals(endInterval, that.endInterval) &&
                Objects.equals(interval, that.interval) &&
                Objects.equals(medicationPlan, that.medicationPlan) &&
                Objects.equals(medication, that.medication);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startInterval, endInterval, interval, medicationPlan, medication);
    }
}
