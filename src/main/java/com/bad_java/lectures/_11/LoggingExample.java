package com.bad_java.lectures._11;

import com.bad_java.lectures._08.library.domain.User;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * log4j
 * JUL - java.util.Logging framework
 * JCL - Java Common Logging API
 * SLF4j - Simple Logging Facade for Java
 * Logback
 *
 *
 * log4j2:
 *  - logger
 *  - appender
 *  - layout
 *
 */
@Log4j2
public class LoggingExample {

    /**
     *    . (root logger) ERROR
     *    com.bad_java.homework
     *    com.bad_java.lectures TRACE
     *    com.bad_java.lectures._10.ResourcesExample
     *    com.bad_java.lectures._11.LoggingExample
     *
     * LEVELS:
     *   - fatal
     *   - error
     *   - info
     *   - debug
     *   - warn
     *   - trace
     */
    private static final Logger lecturesLog = LogManager.getLogger("com.bad_java.lectures");

    public static void main(String[] args) {
        User user = User.builder()
                         .id(42)
                         .username("username")
                         .password("asdasd")
                         .type(User.Type.CLIENT)
                         .build();

        Logger root = LogManager.getRootLogger();
        org.apache.logging.log4j.core.Logger ll = (org.apache.logging.log4j.core.Logger) root;
        ll.setLevel(Level.TRACE);
        root.fatal("fatal_root");
        root.trace("trace_root");


        try {
            throwableMethod();
        } catch (RuntimeException ex) {
            log.error("Exception was thrown", ex);
        }

        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
        log.fatal("fatal");

        lecturesLog.fatal("fatal_lectures");

//            logger.log(Level.INFO, "User successfully passed validation {},{}", new Object[] {user.getId(), user.getUsername()});
    }

    public static void throwableMethod() {
        throw new RuntimeException();
    }
}
