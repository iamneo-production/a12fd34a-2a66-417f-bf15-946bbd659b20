package com.virtusa.dao;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FileStorageDao {
    private Long fileId;
    private String patientId;
    private String fileType;
    private String fileName;
    private String fileDescription;
}
