package com.example.LogRolling.logger.rolling;

public interface RollingAppenderStrategy {
    void writeInFile(String logMessage);
}
