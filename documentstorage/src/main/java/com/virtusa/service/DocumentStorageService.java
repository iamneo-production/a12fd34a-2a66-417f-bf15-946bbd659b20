package com.virtusa.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface DocumentStorageService {

    public ResponseEntity<Object> fileUpload(String id, MultipartFile multipartFile, String fileStorage);
    public ResponseEntity<List<Object>> getFileByPatientId(String id);
}
