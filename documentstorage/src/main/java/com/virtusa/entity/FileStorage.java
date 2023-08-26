package com.virtusa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FileStorage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileId;
    private String patientId;
    private String fileType;
    private String fileName;

    @Lob
    @Column(length = 100000)
    private byte[] fileContent;
    private String fileDescription;
}
