package com.virtusa.controller;

import com.virtusa.entity.FileStorage;
import com.virtusa.service.DocumentStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class DocumentStorageController {

    @Autowired
    private DocumentStorageService documentStorageService;

    @PostMapping(value = "/fileUpload/{patientId}", consumes = {
            MediaType.TEXT_PLAIN_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE
    })
    public String uploadFile(@PathVariable("patientId") String id,
                             @RequestPart("fileDescription") String fileDescription, @RequestPart("image") MultipartFile multipartFile) throws IOException {

        return documentStorageService.fileUpload(id, multipartFile, fileDescription);
    }
}
