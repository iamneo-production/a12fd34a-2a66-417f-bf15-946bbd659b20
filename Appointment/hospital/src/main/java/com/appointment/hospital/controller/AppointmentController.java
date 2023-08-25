package com.appointment.hospital.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appointment.hospital.dto.AppointmentDto;
import com.appointment.hospital.dto.ResponseMessage;
import com.appointment.hospital.service.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;
    

    @PostMapping("/book")
      public ResponseEntity<Object> getPagedProductListing(@RequestBody AppointmentDto appointmentDto) {

                ResponseMessage responseMessage = new ResponseMessage();
                AppointmentDto appointmentDto1;
  
                appointmentDto1 = appointmentService.isSlotAvailable(appointmentDto);

                appointmentDto = appointmentService.bookAppointment(appointmentDto);

                responseMessage.setResponse(appointmentDto);

                  return new ResponseEntity<>(
                responseMessage, new HttpHeaders(), HttpStatus.CREATED);

            }

       @GetMapping("/list/{patiendId}")
      public ResponseEntity<Object> getPagedProductListing(@PathVariable String patiendId) {
             ResponseMessage responseMessage = new ResponseMessage();
            List<AppointmentDto>  appointmentDto = new ArrayList<>();

             appointmentDto = appointmentService.getAppointmentDetails(patiendId);

             responseMessage.setResponse(appointmentDto);

             return new ResponseEntity<>(
                responseMessage, new HttpHeaders(), HttpStatus.CREATED);
      }
}
