package com.hackathon.patient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.patient.entity.Patient;
import com.hackathon.patient.repository.PatientRepository;

@Service
public class PatientService {
	
//	@Autowired
//	private PatientInfoRepository patientInfoRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
//	public PatientMedicalInformation savePatientInfo(PatientMedicalInformation patientMedicalInformation) {
//		return patientInfoRepository.save(patientMedicalInformation);
//	}
	
	
	public Patient getByPatientId(int id) {
		return patientRepository.findById(id).get();
	}
	
//	public PatientMedicalInformation getByPatientInfoId(int id) {
//		return patientInfoRepository.findById(id).get();
//	}
	

	
	
	

}
