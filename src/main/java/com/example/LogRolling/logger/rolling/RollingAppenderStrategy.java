package com.example.LogRolling.logger.rolling;

import org.springframework.boot.logging.LogLevel;

import java.io.IOException;

public interface RollingAppenderStrategy {
    void writeInFile(String logMessage, LogLevel level) throws IOException;
}
