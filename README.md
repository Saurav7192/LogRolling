# LogRolling

# 🔐 Smart Logging Strategies with Spring Boot

A **Spring Boot** project demonstrating different types of **rolling log file strategies** using the **Strategy Design Pattern**. It showcases three unique approaches to managing log files based on:

- ⏱️ **Time-based Rolling** – New log file every minute
- 📁 **File Size-based Rolling** – New file when size exceeds 1000 bytes
- ✉️ **Each Message-based Rolling** – New file for each log message

All strategies are **thread-safe** to prevent data loss or file overwrites during concurrent logging.

---

## 🚀 Features

- ✅ Modular and extensible logging system
- ✅ Implements **Strategy Design Pattern**
- ✅ Thread-safe log writes
- ✅ Organized logs by day and hour
- ✅ Single REST API to trigger logging
- ✅ Clean and readable code structure

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot
- Java NIO (File I/O)
- REST API
- Strategy Design Pattern

---

## 🧠 Strategy Overview

| Logger Class     | Strategy Class                   | Description                         |
|------------------|----------------------------------|-------------------------------------|
| `Neo4jLogger`    | `TimeBasedRollingStrategy`       | Rolls log every minute              |
| `TrinityLogger`  | `FileSizeBasedRollingStrategy`   | Rolls log when file > 1000 bytes    |
| `SimpleLogger`   | `EachLogBasedRollingStrategy`    | Rolls log on every message received |

Each strategy implements a common interface:

```java
public interface RollingAppenderStrategy {
    void writeInFile(String logMessage, LogLevel level) throws IOException;
}
```

## 📁 Log Directory Structure
````swift
src/main/java/com/example/LogRolling/logs/
├── eachmessagebasedrolling/
├── filesizerollinglogs/
└── timerollinglogs/
````
Each strategy saves logs by day/hour and file names are uniquely generated (by timestamp or random)

## 🧪 How to Use
### ✅ Start the App
Run the Spring Boot app:
````bash
./mvnw spring-boot:run
````

## 📬 Send Log Message
````curl
curl --location --request POST 'http://localhost:8080/message?message=This%20is%20a%20test%20log'
````
This sends the message to all loggers (Neo4jLogger, TrinityLogger, SimpleLogger), each writing based on their strategy.

## 🧼 Thread Safety
 - All writeInFile methods are synchronized.
 - Prevents race conditions and file overwrites.
 - Ensures safe multi-threaded logging.

## 📦 Project Structure
````css
src/
└── main/
    └── java/
        └── com/example/LogRolling/
            ├── strategies/
            │   ├── TimeBasedRollingStrategy.java
            │   ├── FileSizeBasedRollingStrategy.java
            │   └── EachLogBasedRollingStrategy.java
            ├── loggers/
            │   ├── Neo4jLogger.java
            │   ├── TrinityLogger.java
            │   └── SimpleLogger.java
            ├── controller/
            │   └── LoggingController.java
            ├── util/
            │   └── LogUtils.java
            ├── enums/
            │   └── LogLevel.java
            └── LogRollingApplication.java

````
