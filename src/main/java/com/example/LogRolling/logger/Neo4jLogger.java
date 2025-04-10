package com.example.LogRolling.logger;

import com.example.LogRolling.logger.rolling.RollingAppenderStrategy;
import com.example.LogRolling.logger.rolling.TimeRollingStrategy;

public class Neo4jLogger implements Logger{
    private final RollingAppenderStrategy rollingAppender;

    public Neo4jLogger(){
        rollingAppender = new TimeRollingStrategy();
    }

    @Override
    public void info(String message) {
        rollingAppender.writeInFile(message);
    }

    @Override
    public void error(String message) {

    }
}
