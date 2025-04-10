package com.example.LogRolling.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @PostMapping("/message")
    public String logMessage(@RequestParam("message") String message){
        return null;
    }
}
