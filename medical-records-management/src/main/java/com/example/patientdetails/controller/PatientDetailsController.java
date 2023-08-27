package com.example.patientdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.patientdetails.dto.FileStorage;
import com.example.patientdetails.exception.RecordAlreadyExistsException;
import com.example.patientdetails.external.service.FileStorageService;
import com.example.patientdetails.model.PatientMedicalInformation;
import com.example.patientdetails.model.PatientMedicalInformationDTO;
import com.example.patientdetails.service.interfaces.PatientService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/medical")
public class PatientDetailsController {

	@Autowired
	private PatientService patientService; // Inject your service here
	
	
	@Autowired
	private FileStorageService file;

	@PostMapping("/store/patientDetails/{patientId}")
	public ResponseEntity<String> storePatientDetails(@PathVariable Long patientId,
			@RequestBody PatientMedicalInformation patientMedicalInformation) {

		patientService.storePatientDetails(patientId, patientMedicalInformation);

		return ResponseEntity.status(HttpStatus.CREATED).body("Patient details stored successfully");
	}

	@GetMapping("/get/patientDetails/{patientId}")
	public PatientMedicalInformationDTO getPatientDetails(@PathVariable Long patientId) {
		return patientService.getPatientDetails(patientId);


	}
	
	@GetMapping("/get/details/{id}")
	@CircuitBreaker(name="fileStorageBreaker",fallbackMethod = "fileStorageFallBack")
	public PatientMedicalInformation getDeatils(@PathVariable long id) {
		 PatientMedicalInformation info = patientService.getDeatils(id);
		 ResponseEntity<List<Object>> files = file.getFiles(id);
		 System.out.println(files);
		 info.setFile(files.getBody());
		 return info;
		
	}
	public ResponseEntity<PatientMedicalInformation> fileStorageFallBack(String Id,Exception ex){
		PatientMedicalInformation info=new PatientMedicalInformation(0L,"File Storage Service is Down","Dummy","Dummy","Dummy",null);
		return new ResponseEntity<>(info,HttpStatus.OK);
	}

}