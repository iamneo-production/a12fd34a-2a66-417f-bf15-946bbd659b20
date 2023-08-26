package com.virtusa.service.impl;

import com.virtusa.dao.FileStorageDao;
import com.virtusa.entity.FileStorage;
import com.virtusa.repository.DocumentStorageRepo;
import com.virtusa.service.DocumentStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentStorageServiceImpl implements DocumentStorageService {

    @Autowired
    private DocumentStorageRepo documentStorageRepo;

    @Override
    public ResponseEntity<Object> fileUpload(String id, MultipartFile multipartFile, String fileDescription) {
        try {
            FileStorage fileStorage1 = documentStorageRepo.save(FileStorage.builder().fileName(multipartFile.getOriginalFilename())
                    .fileContent(multipartFile.getBytes())
                    .fileDescription(fileDescription)
                    .fileType(StringUtils.getFilenameExtension(multipartFile.getOriginalFilename()))
                    .patientId(id).build());
            if (fileStorage1.getFileId() != null) {
                return ResponseEntity.ok().body("File uploaded successfully");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Error in saving the file");
            }
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error in saving the file");
        }
    }

    @Override
    public ResponseEntity<List<Object>> getFileByPatientId(String id) {
        List<FileStorage> fileStorageList = documentStorageRepo.getFileStorageByPatientId(id);
        List<FileStorageDao> fileStorageDaoList = new ArrayList<>();

        for (FileStorage fileStorage : fileStorageList) {
            FileStorageDao fileStorageDao = new FileStorageDao();
            fileStorageDao.setFileId(fileStorage.getFileId());
            fileStorageDao.setFileName(fileStorage.getFileName());
            fileStorageDao.setFileType(fileStorage.getFileType());
            fileStorageDao.setFileDescription(fileStorage.getFileDescription());
            fileStorageDao.setPatientId(fileStorage.getPatientId());

            fileStorageDaoList.add(fileStorageDao);
        }
        if (fileStorageList.size() > 0) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(List.of(fileStorageDaoList));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(List.of("No files were found for given patient Id."));
    }
}
