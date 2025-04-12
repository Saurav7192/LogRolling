package com.example.LogRolling.logger.rolling;

import org.springframework.boot.logging.LogLevel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import static com.example.LogRolling.util.LogUtils.createFile;
import static com.example.LogRolling.util.LogUtils.formatLogMessage;

public class FileSizeBasedRollingStrategy implements RollingAppenderStrategy{

    private static final String logPath = "src/main/java/com/example/LogRolling/logs/filesizerollinglogs/%s/%s";
    private Path logFilePath;

    @Override
    public synchronized void writeInFile(String logMessage, LogLevel level) throws IOException {
        LocalDateTime time = LocalDateTime.now();
        if(isRollingUpdateApplicable(logFilePath)){
            rollingUpdate(time);
        }
        Files.write(logFilePath, formatLogMessage(logMessage, level).getBytes(), StandardOpenOption.APPEND);
    }

    private synchronized void rollingUpdate(LocalDateTime time) throws IOException {
        String directoryPath = String.format(logPath, time.getDayOfMonth(), time.getHour());
        String fileName = "logfile-"+ ThreadLocalRandom.current().nextInt(1, 10000) +".txt";
        logFilePath = createFile(directoryPath, fileName);
    }

    private boolean isRollingUpdateApplicable(Path logFilePath) throws IOException {
        if(Objects.isNull(logFilePath)){
            return true;
        }
        return Files.size(logFilePath) > 1000;
    }
}
