package com.example.patientdetails.model;

import java.util.List;

import com.example.patientdetails.dto.FileStorage;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class PatientMedicalInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long patientId;
	private String diseaseName;
	private String diseaseInfectedDuration;
	private String treatmentDescription;
	private String medicinesTaken;
	
	@Transient
	private List<Object> file;

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getDiseaseName() {
		return diseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	public String getDiseaseInfectedDuration() {
		return diseaseInfectedDuration;
	}

	public void setDiseaseInfectedDuration(String diseaseInfectedDuration) {
		this.diseaseInfectedDuration = diseaseInfectedDuration;
	}

	public String getTreatmentDescription() {
		return treatmentDescription;
	}

	public void setTreatmentDescription(String treatmentDescription) {
		this.treatmentDescription = treatmentDescription;
	}

	public String getMedicinesTaken() {
		return medicinesTaken;
	}

	public void setMedicinesTaken(String medicinesTaken) {
		this.medicinesTaken = medicinesTaken;
	}

	public List<Object> getFile() {
		return file;
	}

	public void setFile(List<Object> file) {
		this.file = file;
	}

	public PatientMedicalInformation(Long patientId, String diseaseName, String diseaseInfectedDuration,
			String treatmentDescription, String medicinesTaken, List<Object> file) {
		super();
		this.patientId = patientId;
		this.diseaseName = diseaseName;
		this.diseaseInfectedDuration = diseaseInfectedDuration;
		this.treatmentDescription = treatmentDescription;
		this.medicinesTaken = medicinesTaken;
		this.file = file;
	}

	public PatientMedicalInformation() {
		super();
		
	}

	@Override
	public String toString() {
		return "PatientMedicalInformation [patientId=" + patientId + ", diseaseName=" + diseaseName
				+ ", diseaseInfectedDuration=" + diseaseInfectedDuration + ", treatmentDescription="
				+ treatmentDescription + ", medicinesTaken=" + medicinesTaken + ", file=" + file + "]";
	}
	
	
	


	
}
