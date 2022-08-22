package tasks_for_matrix;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ThreadLocalRandom;

public class Log4jAppender {
    private static final Logger LOGGER = LogManager.getLogger(Log4jAppender.class);

    private static void loggerGenerator() {
        int num = ThreadLocalRandom.current().nextInt(1, 10 + 1);
        for (int i = 0; i < num; i++) {
            LOGGER.info("info: message is correct " + i);
            LOGGER.warn("warn: message is correct " + i);
            LOGGER.error("error: message is correct " + i);
            LOGGER.fatal("fatal: message is correct " + i);
        }

    }


    public static void main(String[] args) {
        loggerGenerator();
    }
}