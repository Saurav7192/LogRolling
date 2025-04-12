package com.example.LogRolling.logger.rolling;

import org.springframework.boot.logging.LogLevel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

import static com.example.LogRolling.util.LogUtils.createFile;
import static com.example.LogRolling.util.LogUtils.formatLogMessage;

public class EachLogBasedRollingStrategy implements RollingAppenderStrategy{
    private static final String logPath = "src/main/java/com/example/LogRolling/logs/eachmessagebasedrolling/%s/%s";
    private Path logFilePath;

    @Override
    public synchronized void writeInFile(String logMessage, LogLevel level) throws IOException {
        LocalDateTime time = LocalDateTime.now();
        if(isRollingUpdateApplicable()){
            rollingUpdate(time);
        }
        Files.write(logFilePath, formatLogMessage(logMessage, level).getBytes(), StandardOpenOption.APPEND);
    }

    private synchronized void rollingUpdate(LocalDateTime time) throws IOException {
        String directoryPath = String.format(logPath, time.getDayOfMonth(), time.getHour());
        String fileName = "logfile-"+ ThreadLocalRandom.current().nextInt(1, 1000000) +".txt";
        logFilePath = createFile(directoryPath, fileName);
    }

    private boolean isRollingUpdateApplicable()  {
        return true;
    }
}
