package com.hackathon.patient.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.patient.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer>{

	Optional<Patient> findByPatientEmailId(String email);
    
}
