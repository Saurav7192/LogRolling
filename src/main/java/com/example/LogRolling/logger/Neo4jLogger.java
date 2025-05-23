package com.example.LogRolling.logger;

import com.example.LogRolling.logger.rolling.RollingAppenderStrategy;
import com.example.LogRolling.logger.rolling.TimeBasedRollingStrategy;
import org.springframework.boot.logging.LogLevel;

public class Neo4jLogger implements Logger{
    private final RollingAppenderStrategy rollingAppender;

    public Neo4jLogger(){
        rollingAppender = new TimeBasedRollingStrategy();
    }

    @Override
    public void info(String message) {
        try{
            rollingAppender.writeInFile(message, LogLevel.INFO);
        } catch (Exception e){
            System.out.println("Exception in Neo4J info Logging "+e);
        }
    }

    @Override
    public void error(String message) {
        try{
            rollingAppender.writeInFile(message, LogLevel.ERROR);
        } catch (Exception e){
            System.out.println("Exception in Neo4J error logging "+e);
        }
    }
}
