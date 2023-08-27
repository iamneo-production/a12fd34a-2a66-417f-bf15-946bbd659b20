package com.hackathon.patient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.hackathon.patient.dto.AuthRequest;
import com.hackathon.patient.entity.HealthcareProvider;
import com.hackathon.patient.exception.DataNotFoundException;
import com.hackathon.patient.service.AuthService;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/store")
public class AuthController {

    Logger log = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private AuthService service;

    @Autowired
    private AuthenticationManager authenticationManager;
    
    
    @GetMapping("/h1")
    public String hello() {
    	return "Ganesh";
    }


    @PostMapping("/healthcareprovider")
    public ResponseEntity<?> addNewHealthcareProvider(@RequestBody HealthcareProvider healthcareprovider) {
        return new  ResponseEntity<>( service.saveHealthcareProvider(healthcareprovider),HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> getToken(@RequestBody AuthRequest authRequest) {

        try{
            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
             return new  ResponseEntity<String>(service.generateToken(authRequest.getUsername()),HttpStatus.ACCEPTED);

        } else {
            log.error("Invalid Access");
            throw new DataNotFoundException("invalid access");
        }
        }
        catch(Exception e){
            log.info(e.getMessage());
        }
        throw new DataNotFoundException("invalid access");
        
    }

    @GetMapping("/validate")
    public Boolean validateToken(@RequestHeader(name = "Authorization" ) String tokenDup) {
        String token= tokenDup.substring(7);
        return  service.validateToken(token);
    }
    
    
    
}
