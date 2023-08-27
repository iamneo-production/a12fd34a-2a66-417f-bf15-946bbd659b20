package com.hackathon.patient.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hackathon.patient.dto.PatientMedicalInformation;

@FeignClient(name="medical-records-management")
public interface PatientMedicalInformationService {
	
	@GetMapping("/medical/get/details/{id}")
	PatientMedicalInformation getInfo(@PathVariable int id);
	
	@PostMapping("/medical/store/patientDetails/{patientId}")
	PatientMedicalInformation saveInfo(@PathVariable int patientId,@RequestBody PatientMedicalInformation patientMedicalInformation);

}
