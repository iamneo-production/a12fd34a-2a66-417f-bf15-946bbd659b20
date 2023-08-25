package com.appointment.hospital.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointment.hospital.dto.AppointmentDto;
import com.appointment.hospital.repository.AppointmentRepo;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepo appointmentRepo;
    
    public AppointmentDto isSlotAvailable(AppointmentDto appointmentDto){

        AppointmentDto appointmentDto2 = new AppointmentDto();

        appointmentDto2 = appointmentRepo.isSlotAvailable(appointmentDto2);

        return appointmentDto2;
    }

    public AppointmentDto bookAppointment(AppointmentDto appointmentDto){
        
        AppointmentDto appointmentDto2 = new AppointmentDto();

        appointmentDto2 = appointmentRepo.bookAppointment(appointmentDto);

        return appointmentDto2;
    }

    public List<AppointmentDto>  getAppointmentDetails(String patiendId){
        List<AppointmentDto>  appointmentDto2 = new ArrayList<>();

        appointmentDto2 = appointmentRepo.getAppointmentDetails(patiendId);

        return appointmentDto2;

    }
}
