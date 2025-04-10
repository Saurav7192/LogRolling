package com.example.LogRolling.service;

import com.example.LogRolling.logger.Logger;
import com.example.LogRolling.logger.Neo4jLogger;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final Logger log;

    public MessageService(){
        log = new Neo4jLogger();
    }

    public void doLogging(){
        log.info("Doing logging");
    }
}
