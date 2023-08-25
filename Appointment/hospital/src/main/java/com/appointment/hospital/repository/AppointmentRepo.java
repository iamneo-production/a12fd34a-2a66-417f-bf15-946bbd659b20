package com.appointment.hospital.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.appointment.hospital.dto.AppointmentDto;


@Repository
public class AppointmentRepo {

    @Autowired
    MongoTemplate mongoTemplate;
    
    public AppointmentDto isSlotAvailable(AppointmentDto appointmentDto){
        AppointmentDto appointmentDtoReturn = new AppointmentDto();
      
        List<String> slot = Arrays.asList("10 AM", "10:30 AM", "11 AM","11:30 AM","6 PM","6:30 PM");

        if(!slot.contains(appointmentDto.getSlotChoosen())){
            appointmentDtoReturn.setResponseString("Slot not available");
        }else{
            appointmentDtoReturn.setResponseString("Slot Available");
        }

        return appointmentDtoReturn;

    }


    public AppointmentDto bookAppointment(AppointmentDto appointmentDto){

        appointmentDto = mongoTemplate.save(appointmentDto, "Appointment");
    
        return appointmentDto;
    }

    public List<AppointmentDto>  getAppointmentDetails(String patiendId){

        List<AppointmentDto> appointmentDto = new ArrayList();
      
        Query query = Query.query(Criteria.where("patientId").is(patiendId));

        appointmentDto = mongoTemplate.find(query, AppointmentDto.class, "Appointment" );

        return   appointmentDto;

    }
}
