package com.example.patientdetails.service.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.patientdetails.exception.RecordAlreadyExistsException;
import com.example.patientdetails.model.PatientMedicalInformation;
import com.example.patientdetails.model.PatientMedicalInformationDTO;
import com.example.patientdetails.repository.PatientRepository;
import com.example.patientdetails.service.interfaces.PatientService;

@Service
public class PatientServiceImplementation implements PatientService {

	@Autowired
	private PatientRepository patientRepository; // Inject your repository here

	public void storePatientDetails(Long patientId, PatientMedicalInformation patient) {

		patientRepository.save(patient);
	}

	public PatientMedicalInformationDTO getPatientDetails(Long patientId) {
		PatientMedicalInformation patient = patientRepository.getById(patientId);
		  try {
		        if (patientRepository.existsById(patientId)) {
		            throw new RecordAlreadyExistsException("Patient Record Already Exists");
		        }

				
		    } catch (RecordAlreadyExistsException ex) {
		       System.err.println(ex);
		    }
		return new PatientMedicalInformationDTO(patient.getDiseaseName(), patient.getDiseaseInfectedDuration(),
				patient.getTreatmentDescription(), patient.getMedicinesTaken());

	
	}

	@Override
	public PatientMedicalInformation getDeatils(long id) {
		Optional<PatientMedicalInformation> findById = patientRepository.findById(id);
		return findById.get();
	}

}
