package com.example.LogRolling.service;

import com.example.LogRolling.logger.Logger;
import com.example.LogRolling.logger.Neo4jLogger;
import com.example.LogRolling.logger.SimpleLogger;
import com.example.LogRolling.logger.TrinityLogger;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final Logger log1;
    private final Logger log2;
    private final Logger log3;

    public MessageService(){
        log1 = new Neo4jLogger();
        log2 = new TrinityLogger();
        log3 = new SimpleLogger();
    }

    public void doLogging(String message){
        log1.info(message);
        log1.error(message);

        log2.info(message);
        log2.error(message);

        log3.info(message);
        log3.error(message);
    }
}
