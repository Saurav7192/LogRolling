package com.example.LogRolling.logger.rolling;

import org.springframework.boot.logging.LogLevel;

public class EachLogRollingStrategy implements RollingAppenderStrategy{
    @Override
    public void writeInFile(String logMessage, LogLevel level) {

    }
}
