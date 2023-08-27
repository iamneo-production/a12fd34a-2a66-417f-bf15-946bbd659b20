package com.example.patientdetails.external.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name="document-service")
public interface FileStorageService {
	
	@GetMapping("/document/file/{id}")
	public ResponseEntity<List<Object>> getFiles(@PathVariable long id);

}
