package com.example.patientdetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.patientdetails.model.PatientMedicalInformation;

@Repository
public interface PatientRepository  extends JpaRepository<PatientMedicalInformation, Long>{

}
