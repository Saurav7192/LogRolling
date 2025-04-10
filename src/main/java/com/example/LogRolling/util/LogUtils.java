package com.example.LogRolling.util;

import org.springframework.boot.logging.LogLevel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

public class LogUtils {

    public static String formatLogMessage(String message, LogLevel level) {
        return String.format("[%s] %s: %s%n", LocalDateTime.now(), level, message);
    }
    public static Path createFile(String directoryPath, String fileName) throws IOException {
        Path filePath = Paths.get(directoryPath, fileName);
        Files.createDirectories(filePath.getParent());
        return Files.createFile(filePath);
    }
}
