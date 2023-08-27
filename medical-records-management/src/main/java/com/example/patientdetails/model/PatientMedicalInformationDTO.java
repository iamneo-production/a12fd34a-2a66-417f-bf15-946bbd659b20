package com.example.patientdetails.model;

public class PatientMedicalInformationDTO {
	public PatientMedicalInformationDTO() {

	}

	public PatientMedicalInformationDTO(String diseaseName, String diseaseInfectedDuration, String treatmentDescription,
			String medicinesTaken) {
		super();
		this.diseaseName = diseaseName;
		this.diseaseInfectedDuration = diseaseInfectedDuration;
		this.treatmentDescription = treatmentDescription;
		this.medicinesTaken = medicinesTaken;
	}

	private String diseaseName;
	private String diseaseInfectedDuration;
	private String treatmentDescription;
	private String medicinesTaken;

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

	// Getters and setters
}
