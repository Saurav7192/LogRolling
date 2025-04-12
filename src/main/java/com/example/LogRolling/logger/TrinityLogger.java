package com.example.LogRolling.logger;

import com.example.LogRolling.logger.rolling.FileSizeBasedRollingStrategy;
import com.example.LogRolling.logger.rolling.RollingAppenderStrategy;
import org.springframework.boot.logging.LogLevel;

public class TrinityLogger implements Logger{
    private final RollingAppenderStrategy rollingAppender;

    public TrinityLogger(){
        rollingAppender = new FileSizeBasedRollingStrategy();
    }

    @Override
    public void info(String message) {
        try{
            rollingAppender.writeInFile(message, LogLevel.INFO);
        } catch (Exception e){
            System.out.println("Exception in Trinity info logging "+e);
        }

    }

    @Override
    public void error(String message) {
        try{
            rollingAppender.writeInFile(message, LogLevel.ERROR);
        } catch (Exception e){
            System.out.println("Exception in Trinity error logging "+e);
        }
    }
}
