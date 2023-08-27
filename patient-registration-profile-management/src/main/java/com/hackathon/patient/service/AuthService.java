package com.hackathon.patient.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.patient.entity.HealthcareProvider;
import com.hackathon.patient.entity.Patient;
import com.hackathon.patient.entity.UserCredential;
import com.hackathon.patient.exception.DuplicateException;
import com.hackathon.patient.repository.HealthcareProviderRepository;
import com.hackathon.patient.repository.PatientRepository;
import com.hackathon.patient.repository.UserCredentialRepository;

import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class AuthService {

	Logger log = LoggerFactory.getLogger(AuthService.class);
	@Autowired
	private UserCredentialRepository repository;
	@Autowired
	private HealthcareProviderRepository healthcareProviderRepository;
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtService jwtService;

	public String savePatient(Patient patient) {
		Optional<Patient> existingPatient = patientRepository.findByPatientEmailId(patient.getPatientEmailId());
		if (existingPatient.isPresent()) {
			log.error("Email Already Present In System " + patient.getPatientEmailId());
			throw new DuplicateException("Email Already Present In System ");
		}
		patient.setPatientPassword(passwordEncoder.encode(patient.getPatientPassword()));
		patient = patientRepository.save(patient);
		log.info("Patient saved with email" + patient.getPatientEmailId());
		UserCredential user = new UserCredential();
		user.setEmail(patient.getPatientEmailId());
		user.setName(patient.getPatientName());
		user.setPassword(patient.getPatientPassword());
		this.saveUser(user);
		return "Patient  added to the system";
	}

	public String saveHealthcareProvider(HealthcareProvider healthcareprovider) {
		Optional<HealthcareProvider> existingHealthcareProvider = healthcareProviderRepository
				.findByEmail(healthcareprovider.getEmail());
		if (existingHealthcareProvider.isPresent()) {
			log.error("Email Already Present In System " + healthcareprovider.getEmail());
			throw new DuplicateException("Email Already Present In System ");
		}
		healthcareprovider.setPassword(passwordEncoder.encode(healthcareprovider.getPassword()));
		healthcareprovider = healthcareProviderRepository.save(healthcareprovider);
		log.info("Health Care Provider saved with email" + healthcareprovider.getEmail());
		UserCredential user = new UserCredential();
		user.setEmail(healthcareprovider.getEmail());
		user.setName(healthcareprovider.getName());
		user.setPassword(healthcareprovider.getPassword());
		this.saveUser(user);
		return "Healthcare Provied added to the system";
	}

	public void saveUser(UserCredential credential) {
		repository.save(credential);
		log.info("User saved with email" + credential.getEmail());
	}

	public String generateToken(String username) {
		return jwtService.generateToken(username);
	}

	public Boolean validateToken(String token) {
		return jwtService.validateToken(token);
	}
}
