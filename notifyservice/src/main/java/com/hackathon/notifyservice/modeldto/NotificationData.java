package com.hackathon.notifyservice.modeldto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NotificationData {

	private String doctor;
	private String patientName;
	private String slotAvailable;
	private Date slotDate;
}
