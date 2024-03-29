package tasks_for_matrix;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationException;

import java.sql.*;
import java.io.*;

import java.util.concurrent.ThreadLocalRandom;

public class Log4jAppender {
   static final Logger LOGGER = LogManager.getLogger(Logger.class);

    public static void loggerGenerator() {
        int num = ThreadLocalRandom.current().nextInt(1, 10 + 1);
        for (int i = 0; i < num; i++) {
            LOGGER.info("info: message is correct " + i);
            LOGGER.warn("warn: message is correct " + i);
            LOGGER.error("error: message is correct " + i);
            LOGGER.fatal("fatal: message is correct " + i);
            LOGGER.debug("Debug");
        }

    }


    public static void main(String[] args) throws IOException, SQLException {
//        loggerGenerator();
        int i = 9999;
        LOGGER.info("info: message is correct " + i);
        LOGGER.warn("warn: message is correct " + i);
        LOGGER.error("error: message is correct " + i);
        LOGGER.fatal("fatal: message is correct " + i);
        LOGGER.debug("Debug");
    }
}