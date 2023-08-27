package com.example.patientdetails.service.interfaces;



import com.example.patientdetails.model.PatientMedicalInformation;
import com.example.patientdetails.model.PatientMedicalInformationDTO;

public interface PatientService {

	void storePatientDetails(Long patientId, PatientMedicalInformation patient) ;

	public PatientMedicalInformationDTO getPatientDetails(Long patientId) ;
	
	public PatientMedicalInformation getDeatils(long id);

}
