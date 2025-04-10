package com.example.LogRolling.util;

import org.springframework.boot.logging.LogLevel;

import java.time.LocalDateTime;

public class LogUtils {

public static String formatLogMessage(String message, LogLevel level) {
    return String.format("[%s] %s: %s%n", LocalDateTime.now(), level, message);
}
}
