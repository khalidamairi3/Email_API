package com.example.emails.controllers;


import com.example.emails.dto.EmailRequest;
import com.example.emails.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("email")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping()
    public ResponseEntity sendEmail(@RequestBody EmailRequest emailRequest) {

        try{
            emailService.sendEmail(emailRequest.getToEmail(),emailRequest.getSubject(),emailRequest.getBody());
            return ResponseEntity.accepted().build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }

    }
}
