package com.hackathon.patient.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.patient.dto.PatientMedicalInformation;
import com.hackathon.patient.entity.Patient;
import com.hackathon.patient.exception.DataNotFoundException;
import com.hackathon.patient.external.service.PatientMedicalInformationService;
import com.hackathon.patient.repository.PatientRepository;
import com.hackathon.patient.service.AuthService;
import com.hackathon.patient.service.PatientService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/store")
public class PatientController {
	
	@Autowired
    private AuthService service;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private PatientMedicalInformationService patientMedicalInformationService;
	
	
    @PostMapping("/patient")
    public ResponseEntity<?> addNewUser(@RequestBody Patient patient) {
        return new  ResponseEntity<>(service.savePatient(patient),HttpStatus.OK);
    }
	
	
	@GetMapping("/get/patients/{id}")
	public Patient getByPatientId(@PathVariable int id) {
		return patientService.getByPatientId(id);
	}
	
	@PutMapping("/get/patients/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable int id,@RequestBody Patient patient) {
		Patient p1=patientRepository.findById(id).orElseThrow(()->new DataNotFoundException("Patient doesn't exist with given Id"+id));
		p1.setPatientName(patient.getPatientName());
		p1.setPatientContactAddress(patient.getPatientContactAddress());
		p1.setPatientContactCity(patient.getPatientContactCity());
		p1.setPatientEmailId(patient.getPatientEmailId());
		p1.setPatientPassword(patient.getPatientPassword());
		p1.setPatientPhoneNo(patient.getPatientPhoneNo());
		Patient updatedPatient=patientRepository.save(p1);
		return ResponseEntity.ok(updatedPatient);
		
	}
	
	@DeleteMapping("/get/patients/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable int id){
		Patient p1=patientRepository.findById(id).orElseThrow(()->new DataNotFoundException("Patient doesn't exist with given Id"+id));
		patientRepository.delete(p1);
		Map<String, Boolean> response= new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	@GetMapping("/get/patientshistory/{id}")
	@CircuitBreaker(name="medicalRecordBreaker",fallbackMethod = "medicalRecordFallback")
	public Patient getByPatientInfoId(@PathVariable int id) {
		Patient p1=patientRepository.findById(id).orElseThrow(()->new DataNotFoundException("Patient doesn't exist with given Id"+id));
		PatientMedicalInformation info = patientMedicalInformationService.getInfo(id);
		p1.setPatientInfo(info);
		return p1;
	}

	
	public ResponseEntity<PatientMedicalInformation> medicalRecordFallback(String id,Exception ex){
		PatientMedicalInformation info=new PatientMedicalInformation(0,"Medical-RECORD-service is DOWN","Dummy","Dummy","Dummy",null);
		return new ResponseEntity<>(info,HttpStatus.OK);
	}
	
	@PostMapping("/get/patientshistory/{id}")
	public Patient saveMedicalInfo(@PathVariable int id,@RequestBody PatientMedicalInformation p) {
		Patient p1=patientRepository.findById(id).orElseThrow(()->new DataNotFoundException("Patient doesn't exist with given Id"+id));
		PatientMedicalInformation saveInfo = patientMedicalInformationService.saveInfo(id, p);
		p1.setPatientInfo(saveInfo);
		return p1;
	}
	

}
