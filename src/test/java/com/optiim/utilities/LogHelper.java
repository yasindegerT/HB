package com.optiim.utilities;

import org.apache.log4j.Logger;

public class LogHelper {
    private static Logger logger = null;
    public static void log(Class className, String logData){
        logger = Logger.getLogger(className);
        logger.info(logData);
    }
}
