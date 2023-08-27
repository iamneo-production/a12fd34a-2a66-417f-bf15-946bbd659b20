package com.hackathon.patient.entity;

import com.hackathon.patient.dto.PatientMedicalInformation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;


@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_Id")
    private int patientId;
    private String patientName;
    private String patientContactAddress;
    private String patientContactCity;	
    private String patientEmailId;
    private String patientPassword;
    private String patientPhoneNo;
    @Transient
    private PatientMedicalInformation patientInfo;
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientContactAddress() {
		return patientContactAddress;
	}
	public void setPatientContactAddress(String patientContactAddress) {
		this.patientContactAddress = patientContactAddress;
	}
	public String getPatientContactCity() {
		return patientContactCity;
	}
	public void setPatientContactCity(String patientContactCity) {
		this.patientContactCity = patientContactCity;
	}
	public String getPatientEmailId() {
		return patientEmailId;
	}
	public void setPatientEmailId(String patientEmailId) {
		this.patientEmailId = patientEmailId;
	}
	public String getPatientPassword() {
		return patientPassword;
	}
	public void setPatientPassword(String patientPassword) {
		this.patientPassword = patientPassword;
	}
	public String getPatientPhoneNo() {
		return patientPhoneNo;
	}
	public void setPatientPhoneNo(String patientPhoneNo) {
		this.patientPhoneNo = patientPhoneNo;
	}
	public PatientMedicalInformation getPatientInfo() {
		return patientInfo;
	}
	public void setPatientInfo(PatientMedicalInformation patientInfo) {
		this.patientInfo = patientInfo;
	}
	public Patient(int patientId, String patientName, String patientContactAddress, String patientContactCity,
			String patientEmailId, String patientPassword, String patientPhoneNo,
			PatientMedicalInformation patientInfo) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientContactAddress = patientContactAddress;
		this.patientContactCity = patientContactCity;
		this.patientEmailId = patientEmailId;
		this.patientPassword = patientPassword;
		this.patientPhoneNo = patientPhoneNo;
		this.patientInfo = patientInfo;
	}
	public Patient() {
		super();
	}
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", patientContactAddress="
				+ patientContactAddress + ", patientContactCity=" + patientContactCity + ", patientEmailId="
				+ patientEmailId + ", patientPassword=" + patientPassword + ", patientPhoneNo=" + patientPhoneNo
				+ ", patientInfo=" + patientInfo + "]";
	}
	
    
	
    
	
	
    
    
    
    
}
