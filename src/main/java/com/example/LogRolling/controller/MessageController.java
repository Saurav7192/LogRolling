package com.example.LogRolling.controller;

import com.example.LogRolling.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    MessageService service;

    @PostMapping("/message")
    public String logMessage(@RequestParam("message") String message){

        service.doLogging(message);
        return "Successfully log written in file";
    }
}
