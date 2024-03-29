package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tests.BaseTest;

public final class LoggerUtils {
    private static final String ERROR = "❌\n";
    private static final String SUCCESS = "✅\n";
    private static final String WARNING = "⚠️";
    private static final String EXCEPTION = "❗";

    private static final Logger logger = LogManager.getLogger( BaseTest.class.getSimpleName()); // ("BaseTest");

    public static void logInfo(String message) {
        logger.info(message);
    }

    public static void logInfoSuccess(String message) {
        logger.info(SUCCESS + message);
    }

    public static void logError(String message) {
        logger.error(ERROR + message);
    }
    public static void logFatal(String message) {
        logger.error(EXCEPTION + ERROR + WARNING + message);
    }
    public static void logWarning(String message) {
        logger.info(WARNING + message);
    }
}
