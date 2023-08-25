package com.virtusa.service;

import com.virtusa.entity.FileStorage;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface DocumentStorageService {

    public String fileUpload(String id, MultipartFile multipartFile, String fileStorage);
}
