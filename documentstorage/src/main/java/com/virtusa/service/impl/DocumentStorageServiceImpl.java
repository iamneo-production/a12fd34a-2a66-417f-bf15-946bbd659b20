package com.virtusa.service.impl;

import com.virtusa.entity.FileStorage;
import com.virtusa.repository.DocumentStorageRepo;
import com.virtusa.service.DocumentStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DocumentStorageServiceImpl implements DocumentStorageService {

    @Autowired
    private DocumentStorageRepo documentStorageRepo;
    @Override
    public String fileUpload(String id, MultipartFile multipartFile, String fileDescription) {
        try {
            FileStorage fileStorage1 = documentStorageRepo.save(FileStorage.builder().fileName(multipartFile.getOriginalFilename())
                    .fileContent(multipartFile.getBytes())
                    .fileDescription(fileDescription)
                    .fileType(StringUtils.getFilenameExtension(multipartFile.getOriginalFilename()))
                    .patientId(id).build());
            if (fileStorage1.getFileId() != null){
                return "File uploaded successfully";
            } else {
                return "Error in saving the file";
            }
        } catch (IOException e) {
            return "Error in saving the file";
        }
    }
}
