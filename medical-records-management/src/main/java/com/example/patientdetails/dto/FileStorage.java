package com.example.patientdetails.dto;

import java.util.Arrays;

public class FileStorage {

  
    private Long fileId;
    private String patientId;
    private String fileType;
    private String fileName;
    private byte[] fileContent;
    private String fileDescription;
	public Long getFileId() {
		return fileId;
	}
	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public byte[] getFileContent() {
		return fileContent;
	}
	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}
	public String getFileDescription() {
		return fileDescription;
	}
	public void setFileDescription(String fileDescription) {
		this.fileDescription = fileDescription;
	}
	public FileStorage(Long fileId, String patientId, String fileType, String fileName, byte[] fileContent,
			String fileDescription) {
		super();
		this.fileId = fileId;
		this.patientId = patientId;
		this.fileType = fileType;
		this.fileName = fileName;
		this.fileContent = fileContent;
		this.fileDescription = fileDescription;
	}
	public FileStorage() {
		super();
	}
	@Override
	public String toString() {
		return "FileStorage [fileId=" + fileId + ", patientId=" + patientId + ", fileType=" + fileType + ", fileName="
				+ fileName + ", fileContent=" + Arrays.toString(fileContent) + ", fileDescription=" + fileDescription
				+ "]";
	}
	
    
}
