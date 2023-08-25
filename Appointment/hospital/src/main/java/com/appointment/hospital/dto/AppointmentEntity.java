package com.appointment.hospital.dto;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection =  "Appointment")
public class AppointmentEntity {
    private String patientId;
    private String doctorName;
    private Date appointmentDateAndTime;
    private String slotChoosen;
    private String DiseaseDiagonisedFor;
    private String responseString;
}
