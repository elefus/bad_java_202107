package com.bad_java.lectures._11;

import com.bad_java.lectures._08.library.domain.User;
import lombok.extern.slf4j.Slf4j;

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
 *  - layout
 *  - appender
 *
 */
@Slf4j
public class LoggingExample {

    /**
     * . (root logger) TRACE
     * com.bad_java.homework
     * com.bad_java.lectures
     * com.bad_java.lectures._10.ResourcesExample
     * com.bad_java.lectures._11.LoggingExample
     * <p>
     * LEVELS:
     * - fatal
     * - error
     * - info
     * - debug
     * - warn
     * - trace
     */
//    private static final Logger log = LoggerFactory.getLogger(LoggingExample.class);


    public static void main(String[] args) {
        User user = User.builder()
                         .id(42)
                         .username("username")
                         .password("asdasd")
                         .type(User.Type.CLIENT)
                         .build();



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

        // J2SE 1.0
        // J2SE 1.1
        // J2SE 1.2
        // J2SE 1.3
        // J2SE 1.4
        // J2SE 5
//            logger.log(Level.INFO, "User successfully passed validation {},{}", new Object[] {user.getId(), user.getUsername()});
    }

    public static void throwableMethod() {
        throw new RuntimeException();
    }
}
