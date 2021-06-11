package com.example.spring.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;

/**
 * Class to complement the UBS model, following the corresponding data structure
 */
@Embeddable
@JsonPropertyOrder({ "sizeScore", "adaptationForSeniorsScore", "medicalEquipmentScore", "medicineScore" })
public class UbsScores {
    @Column(name = "dsc_estrut_fisic_ambiencia")
    @Convert(converter = UbsScoreConverter.class)
    private int sizeScore;

    @Column(name = "dsc_adap_defic_fisic_idosos")
    @Convert(converter = UbsScoreConverter.class)
    private int adaptationForSeniorsScore;

    @Column(name = "dsc_equipamentos")
    @Convert(converter = UbsScoreConverter.class)
    private int medicalEquipmentScore;

    @Column(name = "dsc_medicamentos")
    @Convert(converter = UbsScoreConverter.class)
    private int medicineScore;

    @JsonProperty("size")
    public int getSizeScore() {
        return sizeScore;
    }
    @JsonProperty("size")
    public void setSizeScoreDescription(int sizeScore) {
        this.sizeScore = sizeScore;
    }

    @JsonProperty("adaptation_for_seniors")
    public int getAdaptationForSeniorsScore() {
        return adaptationForSeniorsScore;
    }
    @JsonProperty("adaptation_for_seniors")
    public void setAdaptationForSeniorsScore(int adaptationForSeniorsScore) {
        this.adaptationForSeniorsScore = adaptationForSeniorsScore;
    }

    @JsonProperty("medical_equipment")
    public int getMedicalEquipmentScore() {
        return medicalEquipmentScore;
    }
    @JsonProperty("medical_equipment")
    public void setMedicalEquipmentScore(int medicalEquipmentScore) {
        this.medicalEquipmentScore = medicalEquipmentScore;
    }

    @JsonProperty("medicine")
    public int getMedicineScore() {
        return medicineScore;
    }
    @JsonProperty("medicine")
    public void setMedicineScore(int medicineScore) {
        this.medicineScore = medicineScore;
    }
}
