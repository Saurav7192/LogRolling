package com.example.LogRolling.logger.rolling;

import org.springframework.boot.logging.LogLevel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.Objects;

import static com.example.LogRolling.util.LogUtils.createFile;
import static com.example.LogRolling.util.LogUtils.formatLogMessage;

public class TimeBasedRollingStrategy implements RollingAppenderStrategy{

    private static final String logPath = "src/main/java/com/example/LogRolling/logs/timerollinglogs/%s/%s";
    private Path logFilePath;
    private Integer prevMinute;

    @Override
    public synchronized void writeInFile(String logMessage, LogLevel level) throws IOException {
        LocalDateTime time = LocalDateTime.now();
        if(isRollingUpdateApplicable(time)){
            rollingUpdate(time);
        }
        Files.write(logFilePath, formatLogMessage(logMessage, level).getBytes(), StandardOpenOption.APPEND);
    }

    private synchronized void rollingUpdate(LocalDateTime time) throws IOException {
        String directoryPath = String.format(logPath, time.getDayOfMonth(), time.getHour());
        String fileName = "logfile-"+time.getMinute()+".txt";
        logFilePath = createFile(directoryPath, fileName);
        prevMinute = time.getMinute();
    }

    private boolean isRollingUpdateApplicable(LocalDateTime time){
        int currentMinute = time.getMinute();
        if(Objects.isNull(logFilePath)){
            return true;
        }
        return currentMinute != prevMinute;
    }

}
