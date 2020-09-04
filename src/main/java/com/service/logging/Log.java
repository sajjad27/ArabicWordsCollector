package com.service.logging;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {
    private static final String EXTENTION = ".txt";
    private static final String format = "dd-MM-yyyy";

    private static Logger logger;
    private static FileHandler fileHandler;
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);

    private static String callerClassFileName;

    public static void logWarning(String message) {
        callerClassFileName = getCallerClassFileName();
        basicLog(message, Level.WARNING);
    }

    public static void logFine(String message) {
        callerClassFileName = getCallerClassFileName();
        basicLog(message, Level.FINE);
    }

    private static void basicLog(String message, Level level) {
        try {
            String fileName = getDailyLogFileName();
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            fileHandler = new FileHandler(fileName, true);
            logger = Logger.getLogger(callerClassFileName);
            logger.addHandler(fileHandler);
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);

            logger.setLevel(level);
            message += System.lineSeparator();
            if (level.equals(Level.WARNING)) {
                logger.warning(message);
            } else {
                logger.fine(message);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private static String  setLineSeperator(String message) {
//        String lineSeparator = System.lineSeparator();
//        message += lineSeparator;
//        return message;
//    }


    private static String getDailyLogFileName() {
        String fileName = "dailyLogs/Daily Logs_";
        LocalDateTime today = LocalDateTime.now();
        fileName = fileName + dateTimeFormatter.format(today) + EXTENTION;


        return fileName;
    }

    private static String getCallerClassFileName() {
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        StackTraceElement e = stacktrace[2];//maybe this number needs to be corrected
        String methodName = e.getClassName();
        return methodName;
    }

}
